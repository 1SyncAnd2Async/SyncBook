package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.NoticeService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.vo.NoticeVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.TeacherVO;

@Controller
//@RequestMapping("/notice")
public class MainController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	RegLectService regLectService;
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("index")
	public ModelAndView noticeList(){
		List<NoticeVO> noticeList = noticeService.getMainNoticeList();
		List<OrderVO> bestClassList = regLectService.getBestClassList();
		List<TeacherVO> teacherList = teacherService.getTeacherList();
		System.out.println(bestClassList);
		System.out.println(teacherList);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("noticeList",noticeList);
		mv.addObject("bestClassList",bestClassList);
		mv.addObject("teacherList",teacherList);
		return mv;
	}
	

}
