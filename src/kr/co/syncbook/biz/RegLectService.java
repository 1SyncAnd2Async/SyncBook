package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;

public interface RegLectService {
	public boolean addOrder(RegLectVO v, String post1, String post2);
	public OrderVO getClass(int assign_num);
	public List<OrderVO> getAllClassList();
	public List<MemberClassVO> getMemberClassList(String member_id);
}
