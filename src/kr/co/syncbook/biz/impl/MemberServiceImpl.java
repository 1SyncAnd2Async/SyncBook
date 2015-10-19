package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.dao.MemberDAO;
import kr.co.syncbook.vo.MemberVO;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	@Transactional(readOnly=false)
	public boolean memberJoin(MemberVO member, String post1, String post2) throws RuntimeException {
		StringBuffer postv = new StringBuffer();
		postv.append(post1).append("-").append(post2);
		member.setPost(postv.toString());
		int result = memberDAO.addMember(member);
		MemberVO vo = memberDAO.getMember(member.getId());
		if(memberDAO.getMember(member.getId()).equals(vo.getId()))
			throw new RuntimeException();
		if(result==1) return true;
		else return false;
	}
	
	// ID �ߺ� üũ
	@Override
	@Transactional(readOnly=false)
	public boolean idCheck(String memberId) {
		List<MemberVO> list = memberDAO.getMemberList();
		if(list != null){
			for(MemberVO v : list){
				if(memberId.equals(v.getId()))
					return true;
			}
		}
		return false;
	}

	@Override
	@Transactional(readOnly=false)
	public MemberVO memberLogin(String memberId, String memberPwd) {
		MemberVO member = memberDAO.getMember(memberId);
		if(member != null && member.getId().equals(memberId)) {
			if(member.getPassword().equals(memberPwd)){
				return member;
			}
			return null;
		} else return null;
	}
	
	@Override
	@Transactional(readOnly=false)
	public MemberVO getMember(String memberId){
		MemberVO member = memberDAO.getMember(memberId);
		return member;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean updateMemberProfile(MemberVO member, String post1, String post2) {
		StringBuffer postv = new StringBuffer();
		postv.append(post1).append("-").append(post2);
		member.setPost(postv.toString());
		int result = memberDAO.updateMemberProfile(member);
		if(result==1) return true;
		else return false;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean updateMemberPwd(MemberVO member) {
		int result = memberDAO.updateMemberPwd(member);
		if(result==1) return true;
		else return false;
	}

	@Override
	public boolean pwdCheck(String memberId, String memberPwd) {
		MemberVO member = memberDAO.getMember(memberId);
		if(member != null){
			if(memberPwd.equals(member.getPassword()))
				return true;
		}
		return false;
	}

	@Override
	public List<MemberVO> getMemberList(){
		List<MemberVO> list = memberDAO.getMemberList();
		return list;
	}

	@Override
	public int getMemberTotalCount() {
		// TODO Auto-generated method stub
		return memberDAO.getMemberTotalCount();
	}

}