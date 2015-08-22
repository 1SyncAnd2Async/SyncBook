package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.dao.BookDAO;
import kr.co.syncbook.vo.BookVO;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	BookDAO bookDAO;
	@Override
	public boolean addBook(BookVO book) {
		int result = bookDAO.addBook(book);
		if(result==1) return true;
		else return false;
	}
	@Override
	public boolean updateBook(BookVO book) {
		int result = bookDAO.updateBook(book);
		if(result==1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public boolean deleteBook(String isbn) {
		int result = bookDAO.deleteBook(isbn);
		if(result==1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public BookVO getBook(String isbn) {
		return bookDAO.getBook(isbn);
	}
	@Override
	public List<BookVO> getBookList() {
		List<BookVO> list = bookDAO.getBookList();
		return list;
	}
}
