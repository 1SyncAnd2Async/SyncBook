package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.ReviewDAO;
import kr.co.syncbook.vo.ReviewVO;

@Repository("ReviewDAO")
public class ReviewDAOImpl implements ReviewDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addReview(ReviewVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Review.addReview", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateReview(ReviewVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Review.updateReview", vo);
	}

	@Override
	public int deleteReview(int review_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Review.deleteReview", review_num);
	}

	@Override
	public ReviewVO getReview(int review_num) {
		// TODO Auto-generated method stub
		return (ReviewVO)sqlSession.selectOne("Review.getReview", review_num);
	}

	@Override
	public List<ReviewVO> getReviewList() {
		List<ReviewVO> list = sqlSession.selectList("Review.getReviewList");
		
		return list;
	}

	@Override
	public int updateReviewHit(int review_num) {
		return sqlSession.update("Review.updateReviewHit",review_num);
		
	}

	@Override
	public List<ReviewVO> getReviewSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<ReviewVO> list = (List<ReviewVO>) sqlSession.selectMap("Review.getReviewList",searchKind,searchValue);
		return list;
	}

	@Override
	public ReviewVO getBestReview() {
		// TODO Auto-generated method stub
		return (ReviewVO)sqlSession.selectOne("Review.getBestReview");
	}

}
