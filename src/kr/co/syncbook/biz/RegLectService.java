package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;

public interface RegLectService {
	public boolean addOrder(RegLectVO v, String post1, String post2);
	public OrderVO getClass(int assign_num);
	public List<RegLectVO> getAllOrderList();
	public List<OrderVO> getOrderList(String member_id);
	public List<OrderVO> getAllClassList();
	public List<OrderVO> getBestClassList();
	public List<MemberClassVO> getMemberClassList(String member_id);
	public List<MemberClassVO> getTeacherClassList(String teacher_id);
	public MemberClassVO getMemberClassDetail(MemberClassVO vo);
	public MemberClassVO getTeacherClassDetail(MemberClassVO vo);
	public RegLectVO getLectStatus(int reg_num);
	public int getRegLectTotalCount();

}
