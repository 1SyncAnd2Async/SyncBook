package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.SubjectVO;

public interface SubjectService {
	public boolean addSubject(SubjectVO subject);
	public boolean deleteSubject(int subject_num);
	public SubjectVO getSubject();
	public List<SubjectVO> getSubjectList();
}
