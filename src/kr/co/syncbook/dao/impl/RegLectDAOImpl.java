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
		System.out.println(v);
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
	public List<MemberClassVO> getMemberClassDetail(int reg_num) {
		List<MemberClassVO> list = sqlSession.selectList("RegLect.getMemberClassDetail", reg_num);
		return list;
	}
}
