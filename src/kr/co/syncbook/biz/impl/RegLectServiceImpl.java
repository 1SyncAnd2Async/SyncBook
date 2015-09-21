package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.dao.RegLectDAO;
import kr.co.syncbook.vo.RegLectVO;
@Service("regLectService")
public class RegLectServiceImpl implements RegLectService {
	@Autowired
	private RegLectDAO regLectDAO;
	@Override
	public List<RegLectVO> getAllClassList() {
		List<RegLectVO> list = regLectDAO.getAllClassList();
		return list;
	}
	
}
