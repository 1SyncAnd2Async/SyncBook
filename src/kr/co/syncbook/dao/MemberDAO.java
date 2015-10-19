package kr.co.syncbook.dao;

import java.util.List;
import kr.co.syncbook.vo.MemberVO;

public interface MemberDAO {
	public int addMember(MemberVO member);
	// ������ ��� ����
	public int updateMember(MemberVO member);
	// ����� ������ ����
	public int updateMemberProfile(MemberVO member);
	public int updateMemberPwd(MemberVO member);
	public int deleteMember(String memberId);
	public MemberVO getMember(String memberId);
	public List<MemberVO> getMemberList();
	public int getMemberTotalCount();
}