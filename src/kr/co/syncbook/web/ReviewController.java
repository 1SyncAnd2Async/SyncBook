package kr.co.syncbook.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.ReviewService;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.ReviewVO;

@Controller
//@RequestMapping("/Review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	LectureService lectureService;
	
	@RequestMapping("reviewList")
	public ModelAndView reviewList(){
		List<ReviewVO> list = reviewService.getReviewList();
		ModelAndView mv = new ModelAndView("reviewList");
		mv.addObject("reviewList",list);
		return mv;
	}
	@RequestMapping("reviewForm")
	public ModelAndView writeForm(int lect_num){
		
		LectureVO lecture = lectureService.getLecture(lect_num);
		
		ModelAndView mv = new ModelAndView("reviewForm");
		mv.addObject("lecture", lecture);
		
		return mv;
	}
	@RequestMapping("reviewUpdate")
	public ModelAndView updateForm(int review_num){
		ReviewVO review =  reviewService.getReview(review_num);
		ModelAndView mv = new ModelAndView("reviewUpdate");
		mv.addObject("review",review);
		return mv;
	}
	@RequestMapping("reviewUpdateOk")
	public String ReviewUpdateOk(@ModelAttribute ReviewVO vo, HttpServletRequest request){		
		
		boolean flag=reviewService.reviewUpdate(vo);
		if(flag){
			System.out.println("Review Insert");
			return "redirect:reviewList";
		}else{
			System.out.println("Review Insert Fail");
			return "redirect:index";
		}
	}
	@RequestMapping("reviewWrite")
	public String write(@ModelAttribute ReviewVO vo, HttpServletRequest request){		
		
		boolean flag=reviewService.reviewUpload(vo);
		if(flag){
			System.out.println("Review Insert");
			return "redirect:reviewList";
		}else{
			System.out.println("Review Insert Fail");
			return "redirect:index";
		}
	}
	
	
	
	@RequestMapping("reviewDetail")
	public ModelAndView ReviewDetail(int review_num){
		
		reviewService.reviewHitUpdate(review_num);
		ReviewVO review =  reviewService.getReview(review_num);
		ModelAndView mv = new ModelAndView("reviewDetail");
		mv.addObject("reviewDetail", review);
		
		return mv;
	}
	
	
	@RequestMapping("reviewSearchList")
	public ModelAndView ReviewSearchList(@PathVariable String searchKind, String searchValue){
		System.out.println("searchKind : "+searchKind+"   searchValue"+searchValue);
		List<ReviewVO> list = reviewService.getReviewSearchList(searchKind, searchValue);
		ModelAndView mv = new ModelAndView("reviewList");
		mv.addObject("reviewSearchList",list);
		return mv;
	}
	

}
