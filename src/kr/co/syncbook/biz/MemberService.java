package kr.co.syncbook.biz;

import kr.co.syncbook.vo.MemberVO;

public interface MemberService {
	public boolean memberJoin(MemberVO member);
	public boolean memberLogin(String memberId, String memberPwd);
}
