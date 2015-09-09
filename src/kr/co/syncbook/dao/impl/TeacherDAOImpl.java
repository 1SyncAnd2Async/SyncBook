package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.TeacherDAO;
import kr.co.syncbook.vo.TeacherVO;

@Repository("TeacherDAO")
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addTeacher(TeacherVO teacher) {
		System.out.println(teacher);
		int result = 0;
		try {
			result = sqlSession.insert("Teacher.addTeacher", teacher);
		} catch(DataIntegrityViolationException e) {
			result = 0;
		}
		return result;
	}

	@Override
	public int updateTeacher(TeacherVO Teacher) {
		return 0;
	}
	
	@Override
	public int updateTeacherProfile(TeacherVO teacher) {
		return sqlSession.update("Teacher.updateTeacherProfile", teacher);
	}
	
	@Override
	public int updateTeacherPwd(TeacherVO teacher) {
		return sqlSession.update("Teacher.updateTeacherPwd", teacher);
	}
	
	@Override
	public int deleteTeacher(String id) {
		return 0;
	}

	@Override
	public TeacherVO getTeacher(String id) {
		return (TeacherVO) sqlSession.selectOne("Teacher.getTeacher", id);
	}

	@Override
	public List<TeacherVO> getTeacherList() {
		List<TeacherVO> list = sqlSession.selectList("Teacher.getTeacherList");
		return list;
	}
}