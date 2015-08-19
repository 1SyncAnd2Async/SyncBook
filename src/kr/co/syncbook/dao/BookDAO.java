package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.BookVO;

public interface BookDAO {
	public int addBook(BookVO vo);
	public int updateBook(BookVO vo);
	public int deleteBook(String isbn);
	public BookVO getBook(String isbn);
	public List<BookVO> getBookList();
	public List<BookVO> getBookList(String searchKind, String searchValue);
	
	
	

}
