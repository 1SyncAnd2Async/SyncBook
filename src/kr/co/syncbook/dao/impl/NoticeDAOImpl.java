package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.NoticeDAO;
import kr.co.syncbook.vo.NoticeVO;

@Repository("NoticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addNotice(NoticeVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Notice.addNotice", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Notice.updateNotice", vo);
	}

	@Override
	public int deleteNotice(int notice_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Notice.deleteNotice", notice_num);
	}

	@Override
	public NoticeVO getNotice(int notice_num) {
		// TODO Auto-generated method stub
		return (NoticeVO)sqlSession.selectOne("Notice.getNotice", notice_num);
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> list = sqlSession.selectList("Notice.getNoticeList");
		return list;
	}

	@Override
	public List<NoticeVO> getNoticeList(String searchKind, String searchValue) {
		List<NoticeVO> list = (List<NoticeVO>) sqlSession.selectMap("Notice.getNoticeList", searchKind, searchValue);
		return list;
	}

}
