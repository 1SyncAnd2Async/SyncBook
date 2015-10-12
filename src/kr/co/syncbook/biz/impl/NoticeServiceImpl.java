package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.NoticeService;
import kr.co.syncbook.dao.NoticeDAO;
import kr.co.syncbook.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired 
	NoticeDAO noticeDAO;
	
	@Override
	public boolean noticeUpload(NoticeVO vo) {
		int result = noticeDAO.addNotice(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean noticeUpdate(NoticeVO vo) {
		int result = noticeDAO.updateNotice(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean noticeHitUpdate(int notice_num) {
		int result = noticeDAO.updateNoticeHit(notice_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean noticeDelete(int notice_num) {
		int result = noticeDAO.deleteNotice(notice_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public NoticeVO getNotice(int notice_num) {
		NoticeVO notice  = noticeDAO.getNotice(notice_num);
		return notice;
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		
		List<NoticeVO> list = noticeDAO.getNoticeList();
		return list;
	}

	@Override
	public List<NoticeVO> getNoticeSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<NoticeVO> list = noticeDAO.getNoticeSearchList(searchKind, searchValue);
		return list;
	}

	@Override
	public List<NoticeVO> getMainNoticeList() {
		List<NoticeVO> list = noticeDAO.getMainNoticeList();
		return list;
	}

}
