package kr.co.syncbook.dao.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.BookDAO;
import kr.co.syncbook.vo.BookVO;

@Repository("BookDAO")
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addBook(BookVO book) {
		int result = 0;
		try{
			result = sqlSession.insert("Book.addBook", book);
		} catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateBook(BookVO book) {
		return sqlSession.update("Book.updateBook", book);
	}

	@Override
	public int deleteBook(int book_num) {
		return sqlSession.delete("Book.deleteBook", book_num);
	}

	@Override
	public BookVO getBook(int book_num) {
		return (BookVO) sqlSession.selectOne("Book.getBook", book_num);
	}

	@Override
	public List<BookVO> getBookList() {
		List<BookVO> list = sqlSession.selectList("Book.getBookList");
		return list;
	}


}
