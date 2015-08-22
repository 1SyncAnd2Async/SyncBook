package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.vo.BookVO;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping("/bookList")
	public ModelAndView bookList(){
		List<BookVO> list = bookService.getBookList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("bookList");
		return mav;
	}
	@RequestMapping("/bookDetail")
	public ModelAndView bookDetail(String isbn){
		BookVO book = bookService.getBook(isbn);
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", book);
		mav.setViewName("bookDetail");
		return mav;
	}
}