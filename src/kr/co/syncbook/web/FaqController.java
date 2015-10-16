package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import kr.co.syncbook.biz.FaqService;
import kr.co.syncbook.vo.FaqVO;

@Controller
public class FaqController {
	@Autowired
	FaqService faqService;
	
	@RequestMapping("faqList")
	public ModelAndView faqList(){
		List<FaqVO> list = faqService.getFaqList();
		ModelAndView mv = new ModelAndView("faqList");
		mv.addObject("faqList",list);
		return mv;
	}
	@RequestMapping("faqForm")
	public String writeForm(){
		return "faqForm";
	}
	@RequestMapping("faqUpdate")
	public ModelAndView updateForm(int faq_num){
		FaqVO faq =  faqService.getFaq(faq_num);
		ModelAndView mv = new ModelAndView("faqUpdate");
		mv.addObject("faq",faq);
		return mv;
	}
	@RequestMapping("faqUpdateOk")
	public String faqUpdateOk(FaqVO vo){	
	
		boolean flag=faqService.faqUpdate(vo);
		if(flag){
			System.out.println("Faq Insert");
			return "redirect:faqList";
		}else{
			System.out.println("Faq Insert Fail");
			return "redirect:index";
		}
	}
	@RequestMapping("faqWrite")
	public String write(@ModelAttribute FaqVO vo){		
		
		boolean flag=faqService.faqUpload(vo);
		if(flag){
			System.out.println("Faq Insert");
			return "redirect:faqList";
		}else{
			System.out.println("Faq Insert Fail");
			return "redirect:index";
		}
	}
	
	@RequestMapping("faqDetail")
	public ModelAndView faqDetail(int faq_num){
		
		faqService.faqHitUpdate(faq_num);
		FaqVO faq =  faqService.getFaq(faq_num);
		ModelAndView mv = new ModelAndView("faqDetail");
		mv.addObject("faqDetail", faq);
		return mv;
	}
	@RequestMapping("/faqDelete")
	public ModelAndView deleteSubject(int faq_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = faqService.faqDelete(faq_num);
		if(flag) {
			mav.setViewName("redirect:faqList");
		} else {
			mav.setViewName("redirect:faqList");
		}
		return mav;
	}
	
}
