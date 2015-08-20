package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.NoticeVO;

public interface NoticeDAO {
	public int addNotice(NoticeVO vo);
	public int updateNotice(NoticeVO vo);
	public int updateNoticeHit(int notice_num);
	public int deleteNotice(int notice_num);
	public NoticeVO getNotice(int notice_num);
	public List<NoticeVO> getNoticeList();
	public List<NoticeVO> getNoticeSearchList(String searchKind, String searchValue);
	
	

}
