package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.QuestionDAO;
import kr.co.syncbook.vo.QuestionVO;

@Repository("QuestionDAO")
public class QuestionDAOImpl implements QuestionDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addQuestion(QuestionVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Question.addQuestion", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateQuestion(QuestionVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Question.updateQuestion",vo);
	}

	@Override
	public int deleteQuestion(QuestionVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Question.deleteQuestion", vo);
	}

	@Override 
	public QuestionVO getQuestion(QuestionVO vo) {
		// TODO Auto-generated method stub
		return (QuestionVO) sqlSession.selectOne("Question.getQuestion",vo);
	}

	@Override
	public List<QuestionVO> getIsbnQuestionList(String isbn) {
		
		List<QuestionVO> list = sqlSession.selectList("Question.getQuestionList", isbn);
		
		return list;
	}

	@Override
	public List<QuestionVO> getUnitQuestionList(QuestionVO vo) {
		
		List<QuestionVO> list = sqlSession.selectList("Question.getUnitQuestionList", vo);
		
		return list;
	}

}
