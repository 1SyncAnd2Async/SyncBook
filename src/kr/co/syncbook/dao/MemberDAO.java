package kr.co.syncbook.dao;

import java.util.List;
import kr.co.syncbook.vo.MemberVO;

public interface MemberDAO {
	public int addMember(MemberVO member);
	// 관리자 멤버 수정
	public int updateMember(MemberVO member);
	// 사용자 프로필 수정
	public int updateMemberProfile(MemberVO member);
	public int updateMemberPwd(MemberVO member);
	public int deleteMember(String memberId);
	public MemberVO getMember(String memberId);
	public List<MemberVO> getMemberList();
}