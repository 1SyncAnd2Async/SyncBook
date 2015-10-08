package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.QuestionVO;

public interface QuestionService {
	public boolean addQuestion(QuestionVO question);
	public List<QuestionVO> getQuestionList(int book_num);
}
