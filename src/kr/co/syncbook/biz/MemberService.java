package kr.co.syncbook.biz;

import javax.servlet.http.HttpSession;

import kr.co.syncbook.vo.MemberVO;

public interface MemberService {
	public boolean memberJoin(MemberVO member, String post1, String post2);
	// ID �ߺ� üũ
	public boolean idCheck(String memberId);
	public MemberVO memberLogin(String memberId, String memberPwd);
	public MemberVO getMember(String memberId);
	// ����� ������ ����
	public boolean updateMemberProfile(MemberVO member, String post1, String post2);
}
