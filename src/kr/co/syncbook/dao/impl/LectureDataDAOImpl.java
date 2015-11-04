package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.LectureDataDAO;
import kr.co.syncbook.vo.LectureDataVO;

@Repository("lectureDataDAO")
public class LectureDataDAOImpl implements LectureDataDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addLectureData(LectureDataVO vo) {
		int result = 0;
		try {
			result = sqlSession.insert("LectureData.addLectureData", vo);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		} 
		return result;
	}
	@Override
	public List<LectureDataVO> getLectureDataList(int assign_num) {
		List<LectureDataVO> questionList  = sqlSession.selectList("LectureData.getLectureDataList",assign_num);
		return questionList;
	}
	@Override
	public int deleteLectureData(int num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("LectureData.deleteLectureData", num);
	}
	@Override
	public LectureDataVO getLectureData(int num) {
		// TODO Auto-generated method stub
		return (LectureDataVO) sqlSession.selectOne("LectureData.getLectureData", num);
	}

}
