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
	public List<NoticeVO> getNoticeVOList() {
		List<NoticeVO> list = noticeDAO.getNoticeList();
		return list;
	}

}
