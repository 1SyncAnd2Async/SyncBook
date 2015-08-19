package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.NoticeVO;

public interface NoticeService {
	public boolean noticeUpload(NoticeVO vo);
	public boolean noticeUpdate(NoticeVO vo);
	public boolean noticeDelete(int notice_num);
	public NoticeVO getNotice(int notice_num);
	public List<NoticeVO> getNoticeVOList();

}
