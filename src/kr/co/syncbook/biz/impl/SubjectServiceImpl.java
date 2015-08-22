package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.dao.SubjectDAO;
import kr.co.syncbook.vo.SubjectVO;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDAO subjectDAO;
	@Override
	public boolean addSubject(SubjectVO subject) {
		int result = subjectDAO.addSubject(subject);
		if(result==1) return true;
		else return false;
	}
	@Override
	public SubjectVO getSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectVO> getSubjectList() {
		List<SubjectVO> list = subjectDAO.getSubjectList();
		return list;
	}
	@Override
	public boolean deleteSubject(int subject_num) {
		int result = subjectDAO.deleteSubject(subject_num);
		if(result==1) return true;
		else return false;
	}
}
