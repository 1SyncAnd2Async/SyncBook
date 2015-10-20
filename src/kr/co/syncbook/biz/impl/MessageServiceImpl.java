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
	public List<MessageVO> getMessageList() {
		
		List<MessageVO> list = messageDAO.getMessageList();
		return list;
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

}
