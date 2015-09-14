package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.AssignLectDAO;
import kr.co.syncbook.vo.AssignLectVO;
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
}
