package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.AssignLectService;
import kr.co.syncbook.biz.DataService;
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.AssignLectVO;
import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.PageVO;
import kr.co.syncbook.vo.RegLectVO;

@Controller
public class RegLectController {
	@Autowired
	private RegLectService regLectService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private AssignLectService assignLectService;
	@Autowired
	private DataService dataService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/classListForm")
	public ModelAndView lectureListForm(int page) {
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 5; // 한 페이지당 보여줄 목록 수 - properties
		int pagesPerBlock = 3; // 한 블록당 보여줄 페이지 수 - properties
		if (page == 0)
			page = 1; // 페이지 초기화
		int currentPage = page; // 현재 페이지 값
		int currentBlock = 0; // 현재 블록 초기화
		if (currentPage % pagesPerBlock == 0) { // 현재 블록 초기 값
			currentBlock = currentPage / pagesPerBlock;
		} else { // 다음 블록이냐
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // 시작 목록 값 연산
		int endRow = currentPage * rowsPerPage-1; // 마지막 목록 값 연산    
		// SearchVO에 저장
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// 전체 데이터 값
		int totalRows = lectureService.getTotalCount();
		// 전체 페이지 구하는 공식
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// 전체 블록 값을 구하는 공식
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// 모든 연산된 정보를 PageVO에 저장한다.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);

		List<LectureVO> classList = lectureService.getAllLectureList();
		ModelAndView mav = new ModelAndView();
//		svo.setBegin(String.valueOf(startRow));
//		svo.setEnd(String.valueOf(endRow));
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("classList", classList);
		mav.setViewName("classListForm");
		return mav;
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList() {
		List<RegLectVO> orderList = regLectService.getAllOrderList();
		System.out.println(orderList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderList", orderList);
		mav.setViewName("orderList");
		return mav;
	}

	@RequestMapping("/memberClassList")
	public ModelAndView memberClassList(String id) {
		List<MemberClassVO> memberClassList;
		if(memberService.idCheck(id)) {
			memberClassList = regLectService.getMemberClassList(id);
		} else {
			memberClassList = regLectService.getTeacherClassList(id);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberClassList", memberClassList);
		mav.setViewName("memberClassList");
		return mav;
	}

	@RequestMapping("/memberClassDetail")
	public ModelAndView memberClassDetail(int reg_num, String id) {
		MemberClassVO memberClassDetail;
		MemberClassVO vo = new MemberClassVO();
		vo.setReg_num(reg_num);
		if(memberService.idCheck(id)) {
			vo.setMember_id(id);
			memberClassDetail = regLectService.getMemberClassDetail(vo);
		} else {
			vo.setTeacher_id(id);
			memberClassDetail = regLectService.getTeacherClassDetail(vo);
		}
		List<DataVO> dataList = dataService.getDataList(memberClassDetail.getLect_num());
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberClassDetail", memberClassDetail);
		mav.addObject("dataList", dataList);
		mav.setViewName("memberClassDetail");
		return mav;
	}

	@RequestMapping("/classDetail")
	public ModelAndView classDetail(int lect_num) {
		List<AssignLectVO> teacherList = assignLectService.getClassTeacherList(lect_num);
		LectureVO lecture = lectureService.getLecture(lect_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecture", lecture);
		mav.addObject("classTeacherList", teacherList);
		mav.setViewName("classDetail");
		return mav;
	}

	@RequestMapping("/selectTimetable")
	public void selectTimetable(ServletResponse resp, @RequestParam int lect_num, @RequestParam String teacher_id)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		AssignLectVO assign = new AssignLectVO();
		assign.setLect_num(lect_num);
		assign.setTeacher_id(teacher_id);
		List<AssignLectVO> timeList = assignLectService.getTimeList(assign);
		for (int i = 0; i < timeList.size(); i++) {
			AssignLectVO v = timeList.get(i);
			if (i == 0) {
				out.print(
						"<img class=\"img-responsive profile-img margin-bottom-20\" style=\"height:150px;\"src=\"resources/upload/teacherImg/"
								+ v.getTeacher_img() + "\"><br> <label class=\"label\">占시곤옙표</label>" + v.getDay()
								+ " : " + "<a href=\"orderForm?assign_num=" + v.getAssign_num() + "\">"
								+ v.getBegintime() + " ~ " + v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");

			} else if (i > 0 && timeList.get(i).getDay().equals(timeList.get(i - 1).getDay())) {
				out.print("<a href=\"orderForm?assign_num=" + v.getAssign_num() + "\">" + v.getBegintime() + " ~ "
						+ v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");
			} else {
				out.print("<br>" + v.getDay() + " : " + "<a href=\"orderForm?assign_num=" + v.getAssign_num() + "\">"
						+ v.getBegintime() + " ~ " + v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");
			}
		}
		out.close();
	}

	@RequestMapping("/orderForm")
	public ModelAndView orderForm(int assign_num) {
		OrderVO Class = regLectService.getClass(assign_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Class", Class);
		mav.setViewName("orderForm");
		return mav;
	}

	@RequestMapping("/orderCancel")
	public ModelAndView orderCancel(int lect_num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:classDetail?lect_num=" + lect_num);
		return mav;
	}

	@RequestMapping("/order")
	public ModelAndView order(RegLectVO v, @RequestParam String post1, @RequestParam String post2) {
		ModelAndView mav = new ModelAndView();
		boolean flag = regLectService.addOrder(v, post1, post2);
		if (flag) {
			mav.setViewName("paySuccess");
		} else {
			mav.setViewName("payFailure");
		}
		return mav;
	}

	@RequestMapping("/androidMemberClassList")
	public void androidMemberClassList(String member_id, HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");

		System.out.println(member_id);
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(member_id);

		JSONArray jsonArray = new JSONArray();
		PrintWriter out = null;
		int i = 0;

		System.out.println(member_id);

		System.out.println(memberClassList);

		for (MemberClassVO v : memberClassList) {
			String fullPath = "http://117.17.143.125/BitProject/resources/upload/lectureImg/" + v.getLect_img();
			if (memberClassList != null) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("lect_img", fullPath);
				jsonObject.put("lect_name", v.getLect_name());
				jsonObject.put("lect_time", v.getBeginTime() + "~" + v.getEndTime());
				jsonObject.put("teacher_name", v.getTeacher_name());
				System.out.println(i);

				jsonArray.add(i++, jsonObject);
			}

		}

		i = 0;

		try {
			out = response.getWriter();

			out.println(jsonArray.toJSONString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println(jsonArray.toJSONString());

	}
}
