package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.AssignLectVO;
import kr.co.syncbook.vo.RegLectVO;

public interface AssignLectService {
	public boolean assignLect(AssignLectVO vo);
	public boolean deleteAssignLect(AssignLectVO vo);
	public List<AssignLectVO> getAllAssignLectList();
	public List<AssignLectVO> getClassTeacherList(int lect_num);
	public List<AssignLectVO> getTimeList(AssignLectVO vo);
	
}
