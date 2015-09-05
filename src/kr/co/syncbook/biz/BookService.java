package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.BookVO;

public interface BookService {
	public boolean addBook(BookVO book);
	public boolean updateBook(BookVO book);
	public boolean deleteBook(int book_num);
	public BookVO getBook(int book_num);
	public List<BookVO> getBookList();
	public List<BookVO> getSubjectBookList(int subj_num);
}
