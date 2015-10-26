package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.FaqService;
import kr.co.syncbook.biz.NoticeService;
import kr.co.syncbook.biz.QnaService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.biz.ReviewService;
import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.vo.FaqVO;
import kr.co.syncbook.vo.NoticeVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.QnaVO;
import kr.co.syncbook.vo.ReviewVO;
import kr.co.syncbook.vo.TeacherVO;

@Controller
public class MainController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	RegLectService regLectService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	QnaService qnaService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	FaqService faqService;
	
	@RequestMapping("index")
	public ModelAndView mainPage(){
		List<NoticeVO> noticeList = noticeService.getMainNoticeList();
		List<OrderVO> bestClassList = regLectService.getBestClassList();
		List<TeacherVO> teacherList = teacherService.getTeacherList();
		List<QnaVO> qnaList = qnaService.getMainQnaList();
		ReviewVO bestReview =reviewService.getBestReview();
		bestReview.setWrite_date(bestReview.getWrite_date().substring(0, 16));
		List<FaqVO> faqList = faqService.getFaqList();
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("qnaList",qnaList);
		mv.addObject("noticeList",noticeList);
		mv.addObject("bestReview",bestReview);
		mv.addObject("bestClassList",bestClassList);
		mv.addObject("teacherList",teacherList);
		mv.addObject("faqList",faqList);
		return mv;
	}
}
