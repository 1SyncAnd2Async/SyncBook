package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.LectureVO;

public interface LectureService {
	public boolean lectureUpload(LectureVO vo);
	public boolean lectureUpdate(LectureVO vo);
	public boolean lectureDelete(int lecture_num);
	public LectureVO getLecture(int lecture_num);
	public List<LectureVO> getLectureList();

}
