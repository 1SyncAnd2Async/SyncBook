package kr.co.syncbook.dao;

import java.util.List;
import kr.co.syncbook.vo.MemberVO;

public interface MemberDAO {
	public int addMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(String memberId);
	public MemberVO getMember(String memberId);
	public List<MemberVO> getMemberList();
}