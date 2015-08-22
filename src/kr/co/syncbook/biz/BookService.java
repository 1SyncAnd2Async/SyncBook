package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.BookVO;

public interface BookService {
	public boolean addBook(BookVO book);
	public boolean updateBook(BookVO book);
	public boolean deleteBook(String isbn);
	public BookVO getBook(String isbn);
	public List<BookVO> getBookList();
}
