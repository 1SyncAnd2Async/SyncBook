package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.QuestionService;
import kr.co.syncbook.dao.QuestionDAO;
import kr.co.syncbook.vo.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDAO questionDAO;
	@Override
	public boolean addQuestion(QuestionVO question) {
		int result = questionDAO.addQuestion(question);
		if(result==1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public List<QuestionVO> getQuestionList(int book_num) {
		List<QuestionVO> questionList = questionDAO.getQuestionList(book_num);
		return questionList;
	}
}
