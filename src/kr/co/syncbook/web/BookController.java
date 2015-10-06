package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.biz.QuestionService;
import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.vo.BookVO;
import kr.co.syncbook.vo.QuestionVO;
import kr.co.syncbook.vo.SubjectVO;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private QuestionService questionService;
	@RequestMapping("/book")
	public ModelAndView bookList(){
		List<BookVO> list = bookService.getBookList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		List<SubjectVO> sub_list = subjectService.getSubjectList();
		mav.addObject("subjectList", sub_list);
		mav.setViewName("book");
		return mav;
	}
	@RequestMapping("/bookDetail")
	public ModelAndView bookDetail(int book_num){
		BookVO book = bookService.getBook(book_num);
		List<QuestionVO> questionList = questionService.getQuestionList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", book);
		mav.addObject("questionList", questionList);
		mav.setViewName("bookDetail");
		return mav;
	}
	@RequestMapping("/addBook")
	public ModelAndView addBook(BookVO book){
		ModelAndView mav = new ModelAndView();
		boolean flag = bookService.addBook(book);
		if(flag) {
			mav.setViewName("redirect:book");
		} else {
			mav.setViewName("redirect:book");
		}
		return mav;
		
	}
	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(int book_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = bookService.deleteBook(book_num);
		if(flag) {
			mav.setViewName("redirect:book");
		} else {
			mav.setViewName("redirect:book");
		}
		return mav;
	}
}