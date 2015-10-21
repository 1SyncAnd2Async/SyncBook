package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.MessageVO;

public interface MessageDAO {
	public int addMessage(MessageVO vo);
	public int updateMessage(MessageVO vo);
	public int updateMessageStatus(int message_num);
	public int updateReceiverStatus(int message_num);
	public int updateSenderStatus(int message_num);
	public int deleteMessage(int message_num);
	public MessageVO getMessage(int message_num);
	public List<MessageVO> getReceiveMessageList(String receiver);
	public List<MessageVO> getSendMessageList(String sender);
	public int getMessageTotalCount();
}
