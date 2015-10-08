package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.QuestionDAO;
import kr.co.syncbook.vo.QnaVO;
import kr.co.syncbook.vo.QuestionVO;

@Repository("questionDAO")
public class QuestionDAOImpl implements QuestionDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addQuestion(QuestionVO question) {
		int result = 0;
		try {
			result = sqlSession.insert("Question.addQuestion", question);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		} 
		return result;
	}
	@Override
	public List<QuestionVO> getQuestionList() {
		List<QuestionVO> questionList  = sqlSession.selectList("Question.getQuestionList");
		return questionList;
	}
}
