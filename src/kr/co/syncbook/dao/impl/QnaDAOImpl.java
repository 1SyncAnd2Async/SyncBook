package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.QnaDAO;
import kr.co.syncbook.vo.QnaVO;
import kr.co.syncbook.vo.QnaVO;

@Repository("QnaDAO")
public class QnaDAOImpl implements QnaDAO{
	
	@Autowired SqlSession sqlSession;
	
	@Override
	public int addQna(QnaVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Qna.addQna", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateQna(QnaVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Qna.updateQna", vo);
	}

	@Override
	public int deleteQna(int qna_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Qna.deleteQna", qna_num);
	}

	@Override
	public QnaVO getQna(int qna_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Qna.getQna", qna_num);
	}

	@Override
	public List<QnaVO> getQnaList() {
		List<QnaVO> list  = sqlSession.selectList("Qna.getQnaList");
		return list;
	}

	@Override
	public List<QnaVO> getQnaList(String searchKind, String searchValue) {
		List<QnaVO> list  = (List<QnaVO>)sqlSession.selectMap("Qna.getQnaList", searchKind, searchValue);
		return list;
	}


	@Override
	public List<QnaVO> getQnaSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<QnaVO> list = (List<QnaVO>) sqlSession.selectMap("Qna.getQnaList",searchKind,searchValue);
		return list;
	}

	@Override
	public List<QnaVO> getMainQnaList() {
		List<QnaVO> list = sqlSession.selectList("Qna.getMainQnaList");
		
		return list;
	}

	@Override
	public int updateQnaHit(int qna_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("Qna.updateQnaHit",qna_num);
	}
}
