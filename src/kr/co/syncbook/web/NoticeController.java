package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.NoticeService;
import kr.co.syncbook.vo.NoticeVO;

@Controller
//@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList(){
		List<NoticeVO> list = noticeService.getNoticeList();
		ModelAndView mv = new ModelAndView("noticeList");
		mv.addObject("NoticeList",list);
		return mv;
	}
	@RequestMapping("noticeForm")
	public String writeForm(){
		return "noticeForm";
	}
	@RequestMapping("noticeWrite")
	public String write(@ModelAttribute NoticeVO vo){
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		vo.setNotice_file("null");
		
		boolean flag=noticeService.noticeUpload(vo);
		if(flag){
			System.out.println("Notice Insert");
			return "redirect:index";
		}else{
			System.out.println("Notice Insert Fail");
			return "redirect:index";
		}
	}
	
	@RequestMapping("noticeDetail")
	public ModelAndView noticeDetail(int notice_num){
		noticeService.noticeHitUpdate(notice_num);
		NoticeVO notice =  noticeService.getNotice(notice_num);
		ModelAndView mv = new ModelAndView("noticeDetail");
		mv.addObject("NoticeDetail", notice);
		
		return mv;
	}
	@RequestMapping("noticeSearchList")
	public ModelAndView noticeSearchList(@RequestParam String searchKind, @RequestParam String searchValue){
		System.out.println("searchKind : "+searchKind +"   searchValue : "+searchValue);
		List<NoticeVO> list = noticeService.getNoticeSearchList(searchKind, searchValue);
		ModelAndView mv = new ModelAndView("noticeList");
		mv.addObject("NotciceSearchList",list);
		return mv;
	}
	

}
