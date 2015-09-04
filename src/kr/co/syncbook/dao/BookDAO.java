package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.BookVO;

public interface BookDAO {
	public int addBook(BookVO book);
	public int updateBook(BookVO book);
	public int deleteBook(int book_num);
	public BookVO getBook(int book_num);
	public List<BookVO> getBookList();
	
	
	

}
