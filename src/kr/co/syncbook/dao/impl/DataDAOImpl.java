package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.DataDAO;
import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;

@Repository("dataDAO")
public class DataDAOImpl implements DataDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int addData(DataVO data) {
		int result = 0;
		try {
			result = sqlSession.insert("Data.addData", data);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		} 
		return result;
	}
	@Override
	public List<DataVO> getDataList(int lect_num) {
		List<DataVO> questionList  = sqlSession.selectList("Data.getDataList",lect_num);
		return questionList;
	}
	@Override
	public int deleteData(int data_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("Data.deleteData", data_num);
	}
	@Override
	public DataVO getData(int data_num) {
		// TODO Auto-generated method stub
		return (DataVO) sqlSession.selectOne("Data.getData", data_num);
	}

}
