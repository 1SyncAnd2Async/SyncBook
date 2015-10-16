package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.ReviewVO;

public interface ReviewDAO {
	public int addReview(ReviewVO vo);
	public int updateReview(ReviewVO vo);
	public int updateReviewHit(int review_num);
	public int deleteReview(int review_num);
	public ReviewVO getReview(int review_num);
	public List<ReviewVO> getReviewList();
	public ReviewVO getBestReview();
	public List<ReviewVO> getReviewSearchList(String searchKind, String searchValue);
	
	

}
