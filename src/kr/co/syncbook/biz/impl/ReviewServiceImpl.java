package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.ReviewService;
import kr.co.syncbook.dao.ReviewDAO;
import kr.co.syncbook.vo.ReviewVO;

@Service("ReviewService")
public class ReviewServiceImpl implements ReviewService{

	@Autowired 
	ReviewDAO reviewDAO;
	
	@Override
	public boolean reviewUpload(ReviewVO vo) {
		int result = reviewDAO.addReview(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean reviewUpdate(ReviewVO vo) {
		int result = reviewDAO.updateReview(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean reviewHitUpdate(int review_num) {
		int result = reviewDAO.updateReviewHit(review_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean reviewDelete(int review_num) {
		int result = reviewDAO.deleteReview(review_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ReviewVO getReview(int review_num) {
		ReviewVO Review  = reviewDAO.getReview(review_num);
		return Review;
	}

	@Override
	public List<ReviewVO> getReviewList() {
		
		List<ReviewVO> list = reviewDAO.getReviewList();
		return list;
	}

	@Override
	public List<ReviewVO> getReviewSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<ReviewVO> list = reviewDAO.getReviewSearchList(searchKind, searchValue);
		return list;
	}

	@Override
	public ReviewVO getBestReview() {
		ReviewVO review  = reviewDAO.getBestReview();
		return review;
	}
	@Override
	public int getReviewTotalCount() {
		return reviewDAO.getReviewTotalCount();
	}


}
