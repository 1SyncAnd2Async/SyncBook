package kr.co.syncbook.dao.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.BookDAO;
import kr.co.syncbook.vo.BookVO;

@Repository("BookDAO")
public class BookDAOImpl implements BookDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addBook(BookVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Book.addBook", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateBook(BookVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Book.updateBook", vo);
	}

	@Override
	public int deleteBook(String isbn) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Book.deleteBook", isbn);
	}

	@Override
	public BookVO getBook(String isbn) {
		// TODO Auto-generated method stub
		return (BookVO) sqlSession.selectOne("Book.getBook", isbn);
	}

	@Override
	public List<BookVO> getBookList() {
		List<BookVO> list = sqlSession.selectList("Book.getBookList");
		return list;
	}

	@Override
	public List<BookVO> getBookList(String searchKind, String searchValue) {
		List<BookVO> list = (List<BookVO>) sqlSession.selectMap("Book.getBookList", searchKind, searchValue);
		return list;
	}

}
