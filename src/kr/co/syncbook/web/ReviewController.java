package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.ReviewService;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.PageVO;
import kr.co.syncbook.vo.ReviewVO;

@Controller
//@RequestMapping("/Review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	LectureService lectureService;
	
	@RequestMapping("reviewList")
	public ModelAndView reviewList(int page){
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 10; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 5; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = reviewService.getReviewTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
		List<ReviewVO> list = reviewService.getReviewList();
		
		for(ReviewVO v : list) {
			v.setWrite_date(v.getWrite_date().substring(0, 16));
		}
		
		ModelAndView mv = new ModelAndView("reviewList");
		mv.addObject("pageInfo", pageInfo);
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
	public ModelAndView updateForm(int review_num, int lect_num){
		ReviewVO review =  reviewService.getReview(review_num);
		LectureVO lecture = lectureService.getLecture(lect_num);
		ModelAndView mv = new ModelAndView("reviewUpdate");
		mv.addObject("review",review);
		mv.addObject("lecture", lecture);
		return mv;
	}
	@RequestMapping("reviewUpdateOk")
	public ModelAndView ReviewUpdateOk(@ModelAttribute ReviewVO vo){		
		ModelAndView mav = new ModelAndView();
		boolean flag=reviewService.reviewUpdate(vo);
		if(flag){
			mav.setViewName("redirect:reviewList?page=1");
		}else{
			mav.setViewName("redirect:index");
		}
		return mav;
	}
	@RequestMapping("reviewWrite")
	public ModelAndView write(@ModelAttribute ReviewVO vo){		
		ModelAndView mav = new ModelAndView();
		boolean flag=reviewService.reviewUpload(vo);
		if(flag){
			mav.setViewName("redirect:reviewList?page=1");
		}else{
			mav.setViewName("redirect:index");
		}
		return mav;
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
		for(ReviewVO v : list) {
			v.setWrite_date(v.getWrite_date().substring(0, 16));
		}
		ModelAndView mv = new ModelAndView("reviewList");
		mv.addObject("reviewSearchList",list);
		return mv;
	}
	@RequestMapping("/reviewDelete")
	public ModelAndView deleteSubject(int review_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = reviewService.reviewDelete(review_num);
		if(flag) {
			mav.setViewName("redirect:reviewList?page=1");
		} else {
			mav.setViewName("redirect:reviewList?page=1");
		}
		return mav;
	}

}
