package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.SubjectVO;

public interface SubjectDAO {
	public int addSubject(SubjectVO subject);
	public int updateSubject(SubjectVO subject);
	public int deleteSubject(int subj_num);
	public SubjectVO getSubject(int subj_num);
	public List<SubjectVO> getSubjectList();
}
