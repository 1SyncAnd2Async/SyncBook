package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.ReviewVO;

public interface ReviewService {
	public boolean reviewUpload(ReviewVO vo);
	public boolean reviewUpdate(ReviewVO vo);
	public boolean reviewHitUpdate(int review_num);
	public boolean reviewDelete(int review_num);
	public ReviewVO getReview(int review_num);
	public List<ReviewVO> getReviewList();
	public ReviewVO getBestReview();
	public List<ReviewVO> getReviewSearchList(String searchKind, String searchValue);
	public int getReviewTotalCount();
}
