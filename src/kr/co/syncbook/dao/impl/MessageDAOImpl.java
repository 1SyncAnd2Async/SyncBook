package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.MessageDAO;
import kr.co.syncbook.vo.MessageVO;

@Repository("MessageDAO")
public class MessageDAOImpl implements MessageDAO{
	
	@Autowired SqlSession sqlSession;
	
	@Override
	public int addMessage(MessageVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Message.addMessage", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}

	@Override
	public int updateMessage(MessageVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Message.updateMessage", vo);
	}

	@Override
	public int deleteMessage(int message_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Message.deleteMessage", message_num);
	}

	@Override
	public MessageVO getMessage(int message_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Message.getMessage", message_num);
	}

	@Override
	public int updateMessageStatus(int message_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("Message.updateMessageStatus",message_num);
	}

	@Override
	public List<MessageVO> getReceiveMessageList(String receiver) {
		List<MessageVO> list  = sqlSession.selectList("Message.getReceiveMessageList",receiver);
		return list;
	}

	@Override
	public List<MessageVO> getSendMessageList(String sender) {
		List<MessageVO> list  = sqlSession.selectList("Message.getSendMessageList",sender);
		return list;
	}

	@Override
	public int updateReceiverStatus(int message_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("Message.updateReceiverStatus", message_num);
	}

	@Override
	public int updateSenderStatus(int message_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("Message.updateSenderStatus", message_num);
	}

	@Override
	public int getReceiverMessageTotalCount(String receiver) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Message.getReceiverMessageTotalCount", receiver);
	}

	@Override
	public int getSenderMessageTotalCount(String sender) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Message.getSenderMessageTotalCount", sender);
	}

	@Override
	public int getMessageNotReadCount(String receiver) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Message.getMessageNotReadCount", receiver);
	}
}
