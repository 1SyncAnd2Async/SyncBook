package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.LectureVO;

public interface LectureDAO {
	public int addLecture(LectureVO vo);
	public int updateLecture(LectureVO vo);
	public int deleteLecture(int lect_num);	
	public int getTotalCount();
	public LectureVO getLecture(int lect_num);
	public List<LectureVO> getAllLectureList();
	public List<LectureVO> getAllLecture();
	public List<LectureVO> getLectureList(int subj_num);
	public List<LectureVO> getAllSubjectLecture(int subj_num);
}