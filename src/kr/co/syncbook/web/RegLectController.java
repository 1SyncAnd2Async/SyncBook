package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;

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
    		if(i>0 && timeList.get(i).getDay().equals(timeList.get(i-1).getDay())) {
    			out.print(v.getBegintime() +" ~ "+ v.getEndtime() + "&nbsp&nbsp&nbsp&nbsp");
    		}
    		else {
    			out.print("<br>" + v.getDay() + " : " + v.getBegintime() +" ~ "+ v.getEndtime() + "&nbsp&nbsp&nbsp&nbsp");
    		}
	    }
	    out.close();
	}
}
