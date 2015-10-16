package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.LectureVO;

public interface LectureService {
	public boolean addLecture(LectureVO vo);
	public boolean updateLecture(LectureVO vo);
	public boolean deleteLecture(int lect_num);
	public int getTotalCount();
	public LectureVO getLecture(int lect_num);
	public List<LectureVO> getAllLectureList();
	public List<LectureVO> getLectureList(int subj_num);

}
