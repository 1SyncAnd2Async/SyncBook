package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.RegLectVO;

@Controller
public class RegLectController {
	@Autowired
	private RegLectService regLectService;
	@RequestMapping("/classListForm")
	public ModelAndView lectureListForm(){
		List<RegLectVO> classList = regLectService.getAllClassList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("classList", classList);
		mav.setViewName("classListForm");
		return mav;
	}
}
