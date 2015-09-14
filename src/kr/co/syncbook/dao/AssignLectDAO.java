package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.AssignLectVO;

public interface AssignLectDAO {
	public int assignLect(AssignLectVO vo);
	public int deleteAssignLect(AssignLectVO vo);	
	public List<AssignLectVO> getAllAssignLectList();
}
