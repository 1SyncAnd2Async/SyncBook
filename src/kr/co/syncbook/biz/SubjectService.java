package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.SubjectVO;

public interface SubjectService {
	public boolean addSubject(SubjectVO subject);
	public boolean deleteSubject(int subj_num);
	public SubjectVO getSubject(int subj_num);
	public List<SubjectVO> getSubjectList();
	public List<SubjectVO> getAssignSubjectList();
}
