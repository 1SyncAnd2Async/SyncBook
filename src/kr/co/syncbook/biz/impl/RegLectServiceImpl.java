package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.dao.RegLectDAO;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;
@Service("regLectService")
public class RegLectServiceImpl implements RegLectService {
	@Autowired
	private RegLectDAO regLectDAO;
	@Override
	public boolean addOrder(RegLectVO v, String post1, String post2) {
		StringBuffer postv = new StringBuffer();
		postv.append(post1).append("-").append(post2);
		v.setPost(postv.toString());
		int result = regLectDAO.addOrder(v);
		if(result==1) return true;
		else return false;
	}
	@Override
	public OrderVO getClass(int assign_num) {
		OrderVO v = regLectDAO.getClass(assign_num);
		return v;
	}
	@Override
	public List<OrderVO> getAllClassList() {
		List<OrderVO> list = regLectDAO.getAllClassList();
		return list;
	}
	@Override
	public List<MemberClassVO> getMemberClassList(String member_id) {
		List<MemberClassVO> list = regLectDAO.getMemberClassList(member_id);
		return list;
	}
	@Override
	public List<MemberClassVO> getTeacherClassList(String teacher_id) {
		List<MemberClassVO> list = regLectDAO.getTeacherClassList(teacher_id);
		return list;
	}
	@Override
	public MemberClassVO getMemberClassDetail(MemberClassVO vo) {
		MemberClassVO memberClass = regLectDAO.getMemberClassDetail(vo);
		return memberClass;
	}
	@Override
	public MemberClassVO getTeacherClassDetail(MemberClassVO vo) {
		MemberClassVO memberClass = regLectDAO.getTeacherClassDetail(vo);
		return memberClass;
	}
	@Override
	public List<OrderVO> getOrderList(String member_id) {
		List<OrderVO> list = regLectDAO.getOrderList(member_id);
		return list;
	}
	@Override
	public List<RegLectVO> getAllOrderList() {
		List<RegLectVO> list = regLectDAO.getAllOrderList();
		return list;
	}
	@Override
	public List<OrderVO> getBestClassList() {
		List<OrderVO> list = regLectDAO.getBestClassList();
		return list;
	}
	@Override
	public RegLectVO getLectStatus(int reg_num) {
		RegLectVO result = regLectDAO.getlectStatus(reg_num);
		return result;
	}
	@Override
	public int getRegLectTotalCount() {
		// TODO Auto-generated method stub
		return regLectDAO.getRegLectTotalCount();
	}
}
