package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<NoticeVO> list = noticeService.getNoticeVOList();
		ModelAndView mv = new ModelAndView("noticeList");
		mv.addObject("NoticeList",list);
		return mv;
	}

}
