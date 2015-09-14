package kr.co.syncbook.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.syncbook.dao.RegLectDAO;
import kr.co.syncbook.vo.RegLectVO;

@Repository("regLectDAO")
public class RegLectDAOImpl implements RegLectDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<RegLectVO> getAllClassList() {
		List<RegLectVO> list = sqlSession.selectList("RegLect.getAllClassList");
		return list;
	}

}
