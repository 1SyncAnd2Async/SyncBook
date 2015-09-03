package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.MemberVO;

public interface MemberService {
	public boolean memberJoin(MemberVO member, String post1, String post2);
	// ID 중복 체크
	public boolean idCheck(String memberId);
	public MemberVO memberLogin(String memberId, String memberPwd);
	public MemberVO getMember(String memberId);
	// 사용자 프로필 수정
	public boolean updateMemberProfile(MemberVO member, String post1, String post2);
	public boolean updateMemberPwd(MemberVO member);
	public boolean pwdCheck(String memberId, String memberPwd);
	public List<MemberVO> getMemberList();
}
