package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.AssignLectVO;

public interface AssignLectService {
	public boolean assignLect(AssignLectVO vo);
	public boolean deleteAssignLect(AssignLectVO vo);
	public List<AssignLectVO> getAllAssignLectList();
}
