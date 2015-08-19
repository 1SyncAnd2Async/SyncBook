package kr.co.syncbook.biz;

import kr.co.syncbook.vo.MemberVO;

public interface MemberService {
	public boolean memberJoin(MemberVO member, String post1, String post2);
	public boolean idCheck(String memberId);
	public boolean memberLogin(String memberId, String memberPwd);
}
