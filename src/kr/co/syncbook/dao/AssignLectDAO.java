package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.AssignLectVO;

public interface AssignLectDAO {
	public int assignLect(AssignLectVO vo);
	public int deleteAssignLect(AssignLectVO vo);	
	public List<AssignLectVO> getAllAssignLectList();
	public List<AssignLectVO> getClassTeacherList(int lect_num);
	public List<AssignLectVO> getTimeList(AssignLectVO vo);
	public int getTotalCount();
}