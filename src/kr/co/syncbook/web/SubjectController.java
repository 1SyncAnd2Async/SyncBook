package kr.co.syncbook.web;

import java.util.List;

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
