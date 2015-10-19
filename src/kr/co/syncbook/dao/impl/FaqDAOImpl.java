package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.FaqDAO;
import kr.co.syncbook.vo.FaqVO;

@Repository("FaqDAO")
public class FaqDAOImpl implements FaqDAO{
	
	@Autowired SqlSession sqlSession;
	
	@Override
	public int addFaq(FaqVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Faq.addFaq", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateFaq(FaqVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Faq.updateFaq", vo);
	}

	@Override
	public int deleteFaq(int faq_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Faq.deleteFaq", faq_num);
	}

	@Override
	public FaqVO getFaq(int faq_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Faq.getFaq", faq_num);
	}

	@Override
	public List<FaqVO> getFaqList() {
		List<FaqVO> list  = sqlSession.selectList("Faq.getFaqList");
		return list;
	}

	@Override
	public List<FaqVO> getFaqList(String searchKind, String searchValue) {
		List<FaqVO> list  = (List<FaqVO>)sqlSession.selectMap("Faq.getFaqList", searchKind, searchValue);
		return list;
	}


	@Override
	public List<FaqVO> getFaqSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<FaqVO> list = (List<FaqVO>) sqlSession.selectMap("Faq.getFaqList",searchKind,searchValue);
		return list;
	}

	@Override
	public List<FaqVO> getMainFaqList() {
		List<FaqVO> list = sqlSession.selectList("Faq.getMainFaqList");
		
		return list;
	}

	@Override
	public int updateFaqHit(int faq_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("Faq.updateFaqHit",faq_num);
	}

	@Override
	public int getFaqTotalCount() {
		return sqlSession.selectOne("Faq.getFaqTotalCount");
	}
}
