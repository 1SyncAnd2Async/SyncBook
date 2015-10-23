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
	public SubjectVO getSubject(int subj_num) {
		SubjectVO subject = subjectDAO.getSubject(subj_num);
		return subject;
	}
	@Override
	public List<SubjectVO> getSubjectList() {
		List<SubjectVO> list = subjectDAO.getSubjectList();
		return list;
	}
	@Override
	public boolean deleteSubject(int subj_num) {
		int result = subjectDAO.deleteSubject(subj_num);
		if(result==1) return true;
		else return false;
	}
	@Override
	public List<SubjectVO> getAssignSubjectList() {
		List<SubjectVO> list = subjectDAO.getAssignSubjectList();
		return list;
	}
}
