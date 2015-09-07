package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.LectureDAO;
import kr.co.syncbook.vo.LectureVO;

@Repository("LectureDAO")
public class LectureDAOImpl implements LectureDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addLecture(LectureVO vo) {
		int result = 0;
		try{
			result = sqlSession.insert("Lecture.addLecture", vo);
		}catch(DataIntegrityViolationException e){
			result = 0;
		}
		return result;
		
	}

	@Override
	public int updateLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("Lecture.updateLecture", vo);
	}

	@Override
	public int deleteLecture(int lecture_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Lecture.deleteLecture", lecture_num);
	}

	@Override
	public LectureVO getLecture(int lecture_num) {
		// TODO Auto-generated method stub
		return (LectureVO) sqlSession.selectOne("Lecture.getLecture", lecture_num);
	}

	@Override
	public List<LectureVO> getAllLectureList() {
		List<LectureVO> list = sqlSession.selectList("Lecture.getAllLectureList");
		return list;
	}

	@Override
	public List<LectureVO> getLectureList(int subj_num) {
		List<LectureVO> list = sqlSession.selectList("Lecture.getLectureList", subj_num);
		return list;
	}

}
