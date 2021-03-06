package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.RegLectDAO;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.RegLectVO;

@Repository("regLectDAO")
public class RegLectDAOImpl implements RegLectDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addOrder(RegLectVO v) {
		int result = 0;
		try {
			result = sqlSession.insert("Order.addOrder", v);
			sqlSession.update("Order.updateStatus", v.getAssign_num());
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	@Override
	public OrderVO getClass(int assign_num) {
		OrderVO v = sqlSession.selectOne("Order.getClasses", assign_num);
		return v;
	}
	@Override
	public List<OrderVO> getAllClassList() {
		List<OrderVO> list = sqlSession.selectList("Order.getAllClassList");
		return list;
	}
	@Override
	public List<MemberClassVO> getMemberClassList(String member_id) {
		List<MemberClassVO> list = sqlSession.selectList("RegLect.getMemberClassList", member_id);
		return list;
	}
	@Override
	public List<MemberClassVO> getTeacherClassList(String teacher_id) {
		List<MemberClassVO> list = sqlSession.selectList("RegLect.getTeacherClassList", teacher_id);
		return list;
	}
	@Override
	public MemberClassVO getMemberClassDetail(MemberClassVO vo) {
		return (MemberClassVO) sqlSession.selectOne("RegLect.getMemberClassDetail", vo);
	}
	@Override
	public MemberClassVO getTeacherClassDetail(MemberClassVO vo) {
		return (MemberClassVO) sqlSession.selectOne("RegLect.getTeacherClassDetail", vo);
	}
	@Override
	public List<OrderVO> getOrderList(String member_id) {
		List<OrderVO> list = sqlSession.selectList("Order.getOrderList",member_id);
		return list;
	}
	@Override
	public List<RegLectVO> getAllOrderList() {
		List<RegLectVO> list = sqlSession.selectList("Order.getAllOrderList");
		return list;
	}
	@Override
	public List<OrderVO> getBestClassList() {
		List<OrderVO> list = sqlSession.selectList("Order.getBestClassList");
		return list;
	}
	@Override
	public RegLectVO getlectStatus(int reg_num) {
		RegLectVO result = sqlSession.selectOne("RegLect.lectureStatus", reg_num);
		return result;
	}
	@Override
	public int getRegLectTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("RegLect.getRegLectTotalCount");
	}
}