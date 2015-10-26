package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import kr.co.syncbook.vo.MemberVO;
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
		int rowsPerPage = 5; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 3; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = lectureService.getTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
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
	@RequestMapping("/subjectClassList")
	public ModelAndView subjectClassList(int page, int subj_num) { // subj_num 이용
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 5; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 3; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = lectureService.getTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
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
	public ModelAndView orderList(int page) {
		
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 10; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 5; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = regLectService.getRegLectTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
		
		List<RegLectVO> orderList = regLectService.getAllOrderList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderList", orderList);
		mav.addObject("pageInfo", pageInfo);
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
	public ModelAndView memberClassDetail(int reg_num, String id, String msg) {
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
		mav.addObject("msg", msg);
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
								+ v.getTeacher_img() + "\"><br> <label class=\"label\">�ð�ǥ</label>" + v.getDay()
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
	
	@RequestMapping("lectureStart")
	public ModelAndView lectureStart(int reg_num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		RegLectVO v = regLectService.getLectStatus(reg_num);
		ModelAndView mav = new ModelAndView();
		if(v.getStatus() == 1) {
			mav.addObject("reg_num", reg_num);
			mav.setViewName("lectureStart");
		} else {
			mav.addObject("msg", "Lecture isn't started yet.");
			mav.setViewName("redirect:memberClassDetail?reg_num="+reg_num+"&id="+member.getId());
		}
		return mav;
	}

	@RequestMapping("/androidMemberClassList")
	public void androidMemberClassList(String member_id, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(member_id);

		JSONArray jsonArray = new JSONArray();
		PrintWriter out = null;
		int i = 0;

		for (MemberClassVO v : memberClassList) {
			String fullPath = "http://117.17.143.125/BitProject/resources/upload/lectureImg/" + v.getLect_img();
			if (memberClassList != null) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("lect_img", fullPath);
				jsonObject.put("lect_name", v.getLect_name());
				jsonObject.put("lect_time", v.getBeginTime() + "~" + v.getEndTime());
				jsonObject.put("teacher_name", v.getTeacher_name());
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
	}
}
