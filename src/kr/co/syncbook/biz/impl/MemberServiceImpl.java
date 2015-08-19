package kr.co.syncbook.biz.impl;

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
	public boolean memberJoin(MemberVO member) throws RuntimeException {
		int result = memberDAO.addMember(member);
		if(memberDAO.getMember(member.getId()).equals("aa"))
			throw new RuntimeException();
		if(result==1) return true;
		else return false;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean memberLogin(String memberId, String memberPwd) {
		MemberVO member = memberDAO.getMember(memberId);
		if(member != null && member.getId().equals(memberId)) {
			if(member.getPassword().equals(memberPwd)){
				return true;
			}
			return false;
		}
		else return false;
	}
}