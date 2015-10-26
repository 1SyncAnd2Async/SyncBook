package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.vo.SubjectVO;

@Controller
public class SubjectController {
	@Autowired
	SubjectService subjectService;
	@RequestMapping("/subject")
	public ModelAndView subject(){
		List<SubjectVO> list = subjectService.getSubjectList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("subject");
		return mav;
	}
	
	@RequestMapping("/assignSubject")
	public void assignSubject(ServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<SubjectVO> list = subjectService.getAssignSubjectList();
		
		out.print(
				"<li><a href=\"classListForm?page=1\">전체보기</a></li>");
		for (int i = 0; i < list.size(); i++) {
			SubjectVO subject = list.get(i);
				out.print(
						"<li><a href=\"subjectClassList?page=1&subj_num="+ subject.getSubj_num()
						+ "\">"+subject.getSubj_name()+"</a></li>");
		}
		out.close();
	}
	
	
	
	@RequestMapping("/addSubject")
	public ModelAndView addSubject(SubjectVO subject){
		ModelAndView mav = new ModelAndView();
		boolean flag = subjectService.addSubject(subject);
		if(flag) {
			mav.setViewName("redirect:subject");
		} else {
			mav.setViewName("redirect:subject");
		}
		return mav;
	}
	@RequestMapping("/deleteSubject")
	public ModelAndView deleteSubject(int subject_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = subjectService.deleteSubject(subject_num);
		if(flag) {
			mav.setViewName("redirect:subject");
		} else {
			mav.setViewName("redirect:subject");
		}
		return mav;
	}
}
