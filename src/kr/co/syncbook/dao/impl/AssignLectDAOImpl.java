package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.AssignLectDAO;
import kr.co.syncbook.vo.AssignLectVO;
import kr.co.syncbook.vo.RegLectVO;
@Repository("assignLectDAO")
public class AssignLectDAOImpl implements AssignLectDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int assignLect(AssignLectVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("AssignLect.assignLecture", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
	}
	@Override
	public int deleteAssignLect(AssignLectVO vo) {
		return sqlSession.delete("AssignLect.deleteAssignLect", vo);
	}
	@Override
	public List<AssignLectVO> getAllAssignLectList() {
		List<AssignLectVO> list = sqlSession.selectList("AssignLect.getAllAssignLectList");
		return list;
	}
	@Override
	public List<AssignLectVO> getClassTeacherList(int lect_num) {
		List<AssignLectVO> list = sqlSession.selectList("AssignLect.getClassTeacherList", lect_num);
		return list;
	}
	@Override
	public List<AssignLectVO> getTimeList(AssignLectVO vo) {
		List<AssignLectVO> list = sqlSession.selectList("AssignLect.getTimeList", vo);
		return list;
	}
	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("AssignLect.getTotalCount");
	}
}
