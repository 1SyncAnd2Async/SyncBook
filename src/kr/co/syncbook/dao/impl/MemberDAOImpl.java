package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.MemberDAO;
import kr.co.syncbook.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addMember(MemberVO member) {
		int result = 0;
		try {
			result = sqlSession.insert("Member.addMember", member);
		} catch(DataIntegrityViolationException e) {
			result = 0;
		}
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		return 0;
	}
	
	@Override
	public int updateMemberProfile(MemberVO member) {
		return sqlSession.update("Member.updateMemberProfile", member);
	}
	
	@Override
	public int updateMemberPwd(MemberVO member) {
		return sqlSession.update("Member.updateMemberPwd", member);
	}
	
	@Override
	public int deleteMember(String memberId) {
		return 0;
	}

	@Override
	public MemberVO getMember(String memberId) {
		return (MemberVO) sqlSession.selectOne("Member.getMember", memberId);
	}


	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> list = sqlSession.selectList("Member.getMemberList");
		
		return list;
	}

	@Override
	public int getMemberTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.getMemberTotalCount");
	}
}