package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.BookVO;

public interface BookService {
	public boolean bookUpload(BookVO vo);
	public boolean bookUpdate(BookVO vo);
	public boolean bookDelete(String isbn);
	public BookVO getBook(String isbn);
	public List<BookVO> getBookList();
	
}
