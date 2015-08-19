package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.QuestionVO;

public interface QuestionDAO {
	public int addQuestion(QuestionVO vo);
	public int updateQuestion(QuestionVO vo);
	public int deleteQuestion(QuestionVO vo);	
	public QuestionVO getQuestion(QuestionVO vo);
	public List<QuestionVO> getIsbnQuestionList(String isbn);
	public List<QuestionVO> getUnitQuestionList(QuestionVO vo);

}
