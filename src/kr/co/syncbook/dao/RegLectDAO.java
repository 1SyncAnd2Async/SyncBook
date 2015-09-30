package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;


public interface RegLectDAO {
	public int addOrder(RegLectVO v);
	public OrderVO getClass(int assign_num);
	public List<OrderVO> getAllClassList();
	public List<MemberClassVO> getMemberClassList(String member_id);
	public List<MemberClassVO> getMemberClassDetail(int reg_num);
	
}