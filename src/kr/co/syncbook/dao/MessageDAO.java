package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.MessageVO;

public interface MessageDAO {
	public int addMessage(MessageVO vo);
	public int updateMessage(MessageVO vo);
	public int updateMessageStatus(int message_num);
	public int deleteMessage(int message_num);
	public MessageVO getMessage(int message_num);
	public List<MessageVO> getMessageList();
	public int getMessageTotalCount();
}
