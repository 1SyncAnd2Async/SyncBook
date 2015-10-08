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
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.AssignLectVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;

@Controller
public class RegLectController {
	@Autowired
	private RegLectService regLectService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private AssignLectService assignLectService;
	
	@RequestMapping("/classListForm")
	public ModelAndView lectureListForm(){
		List<LectureVO> classList = lectureService.getAllLectureList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("classList", classList);
		mav.setViewName("classListForm");
		return mav;
	}
	@RequestMapping("/memberClassList")
	public ModelAndView memberClassList(String member_id){
		System.out.println(member_id);
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(member_id);
		
		System.out.println(memberClassList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberClassList", memberClassList);
		mav.setViewName("memberClassList");
		return mav;
	}
	@RequestMapping("/memberClassDetail")
	public ModelAndView memberClassDetail(int reg_num){
		List<MemberClassVO> memberClassDetail = regLectService.getMemberClassDetail(reg_num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberClassDetail", memberClassDetail);
		
		mav.setViewName("memberClassDetail");
		return mav;
	}
	@RequestMapping("/classDetail")
	public ModelAndView classDetail(int lect_num){
		List<AssignLectVO> teacherList = assignLectService.getClassTeacherList(lect_num);
		LectureVO lecture = lectureService.getLecture(lect_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecture", lecture);
		mav.addObject("classTeacherList", teacherList);
		
		mav.setViewName("classDetail");
		return mav;
	}
	
	@RequestMapping("/selectTimetable")  
	public void selectTimetable(ServletResponse resp, @RequestParam int lect_num, @RequestParam String teacher_id) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		AssignLectVO assign = new AssignLectVO();
		assign.setLect_num(lect_num);
		assign.setTeacher_id(teacher_id);
	    List<AssignLectVO> timeList = assignLectService.getTimeList(assign);
    	for(int i=0; i<timeList.size(); i++) {
    		AssignLectVO v = timeList.get(i);
    		if(i==0){
    			out.print("<img class=\"img-responsive profile-img margin-bottom-20\" style=\"height:150px;\"src=\"resources/upload/teacherImg/"
    		+v.getTeacher_img()+"\"><br> <label class=\"label\">�ð�ǥ</label>" + v.getDay() + " : " 
    					+ "<a href=\"orderForm?assign_num="+v.getAssign_num()+"\">"+ v.getBegintime() +" ~ "+ v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");

    		}
    		else if(i>0 && timeList.get(i).getDay().equals(timeList.get(i-1).getDay())) {
    			out.print("<a href=\"orderForm?assign_num="+v.getAssign_num()+"\">"+v.getBegintime() +" ~ "+ v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");
    		}
    		else {
    			out.print("<br>" + v.getDay() + " : " + "<a href=\"orderForm?assign_num="+v.getAssign_num()+"\">"
    		+ v.getBegintime() +" ~ "+ v.getEndtime() + "</a>&nbsp&nbsp&nbsp&nbsp");
    		}
	    }
	    out.close();
	}
	
	@RequestMapping("/orderForm")
	public ModelAndView orderForm(int assign_num){
		OrderVO Class = regLectService.getClass(assign_num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Class", Class);
		mav.setViewName("orderForm");
		return mav;
	}
	
	@RequestMapping("/orderCancel")
	public ModelAndView orderCancel(int lect_num){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:classDetail?lect_num="+lect_num);
		return mav;
	}
	
	@RequestMapping("/order")
	public ModelAndView order(RegLectVO v, @RequestParam String post1, @RequestParam String post2){
		ModelAndView mav = new ModelAndView();
		boolean flag = regLectService.addOrder(v, post1, post2);
		if(flag) {
			mav.setViewName("paySuccess");
		} else {
			mav.setViewName("payFailure");
		}
		return mav;
	}
	
	@RequestMapping("/androidMemberClassList")
	public void androidMemberClassList(String member_id, HttpServletRequest request, HttpServletResponse response){
		
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(member_id);
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(member_id);
		
		JSONArray jsonArray = new JSONArray();
		PrintWriter out = null;
		int i=0;
		
		System.out.println(member_id);
		
		System.out.println(memberClassList);
		
		for(MemberClassVO v : memberClassList) {
			String fullPath = "http://117.17.143.125/BitProject/resources/upload/lectureImg/"+v.getLect_img();
			if(memberClassList != null)	{
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("lect_img", fullPath);
				jsonObject.put("lect_name", v.getLect_name());
				jsonObject.put("lect_time", v.getBeginTime()+"~"+v.getEndTime());
				jsonObject.put("teacher_name", v.getTeacher_name());
				System.out.println(i);
				
				jsonArray.add(i++, jsonObject);
			}
			
		}
		
		i=0;
		
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
