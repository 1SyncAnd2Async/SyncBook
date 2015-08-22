package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.SubjectDAO;
import kr.co.syncbook.vo.SubjectVO;

@Repository("subjectDAO")
public class SubjectDAOImpl implements SubjectDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addSubject(SubjectVO subject) {
		int result = 0;
		try {
			result = sqlSession.insert("Subject.addSubject", subject);
		} catch(DataIntegrityViolationException e) {
			result = 0;
		}
		return result;
	}

	@Override
	public int updateSubject(SubjectVO subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSubject(int subject_num) {
		return sqlSession.delete("Subject.deleteSubject", subject_num);
	}

	@Override
	public SubjectVO getSubject(int subject_num) {
		return sqlSession.selectOne("Subject.getSubject", subject_num);
	}

	@Override
	public List<SubjectVO> getSubjectList() {
		return sqlSession.selectList("Subject.getSubjectList");
	}

}
