package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.QuestionVO;

public interface QuestionService {
	public boolean questionUpload(QuestionVO vo);
	public boolean questionUpdate(QuestionVO vo);
	public boolean questionDelete(QuestionVO vo);
	public QuestionVO getQuestion(QuestionVO vo);
	public List<QuestionVO> getIsbnQuestionList(String isbn);
	public List<QuestionVO> getUnitQuestionList(QuestionVO vo);
	

}
