package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.MessageVO;

public interface MessageService {
	public boolean messageUpload(MessageVO vo);
	public boolean messageUpdate(MessageVO vo);
	public boolean updateReceiverStatus(int message_num);
	public boolean updateSenderStatus(int message_num);
	public boolean messageStatusUpdate(int message_num);
	public boolean messageDelete(int message_num);
	public MessageVO getMessage(int message_num);
	public List<MessageVO> getReceiveMessageList(String receiver);
	public List<MessageVO> getSendMessageList(String sender);
	public int getMessageTotalCount();
}
