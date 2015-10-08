package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.QuestionVO;

public interface QuestionDAO {
	public int addQuestion(QuestionVO question);
	public List<QuestionVO> getQuestionList(int book_num);
}
