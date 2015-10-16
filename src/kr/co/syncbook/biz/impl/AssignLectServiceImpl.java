package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.AssignLectService;
import kr.co.syncbook.dao.AssignLectDAO;
import kr.co.syncbook.vo.AssignLectVO;
@Service("assignLectService")
public class AssignLectServiceImpl implements AssignLectService {
	@Autowired
	AssignLectDAO assignLectDAO;
	@Override
	public boolean assignLect(AssignLectVO assignLect) {
		int result = assignLectDAO.assignLect(assignLect);
		if(result==1) return true;
		else return false;
	}
	@Override
	public boolean deleteAssignLect(AssignLectVO vo) {
		int result = assignLectDAO.deleteAssignLect(vo);
		if(result==1) return true;
		else return false;
	}
	@Override
	public List<AssignLectVO> getAllAssignLectList() {
		List<AssignLectVO> list = assignLectDAO.getAllAssignLectList();
		return list;
	}
	@Override
	public List<AssignLectVO> getClassTeacherList(int lect_num) {
		List<AssignLectVO> list = assignLectDAO.getClassTeacherList(lect_num);
		return list;
	}
	@Override
	public List<AssignLectVO> getTimeList(AssignLectVO vo) {
		List<AssignLectVO> list = assignLectDAO.getTimeList(vo);
		return list;
	}
	@Override
	public int getTotalCount() {
		return assignLectDAO.getTotalCount();
	}
}
