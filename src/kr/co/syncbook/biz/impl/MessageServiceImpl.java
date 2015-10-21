package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.MessageService;
import kr.co.syncbook.dao.MessageDAO;
import kr.co.syncbook.vo.MessageVO;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{

	@Autowired 
	MessageDAO messageDAO;
	@Override
	public boolean messageUpload(MessageVO vo) {
		int result = messageDAO.addMessage(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean messageUpdate(MessageVO vo) {
		int result = messageDAO.updateMessage(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean messageDelete(int message_num) {
		int result = messageDAO.deleteMessage(message_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public MessageVO getMessage(int message_num) {
		MessageVO Message  = messageDAO.getMessage(message_num);
		return Message;
	}

	@Override
	public boolean messageStatusUpdate(int message_num) {
		int result = messageDAO.updateMessageStatus(message_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int getMessageTotalCount() {
		return messageDAO.getMessageTotalCount();
	}

	@Override
	public List<MessageVO> getReceiveMessageList(String receiver) {
		System.out.println("service : "+receiver);
		List<MessageVO> list = messageDAO.getReceiveMessageList(receiver);
		return list;
	}

	@Override
	public List<MessageVO> getSendMessageList(String sender) {
		List<MessageVO> list = messageDAO.getSendMessageList(sender);
		return list;
	}

	@Override
	public boolean updateReceiverStatus(int message_num) {
		int result = messageDAO.updateReceiverStatus(message_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateSenderStatus(int message_num) {
		int result = messageDAO.updateSenderStatus(message_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

}
