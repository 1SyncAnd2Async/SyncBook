package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.LectureDataVO;

public interface LectureDataService {
	public boolean addLectureData(LectureDataVO vo);
	public List<LectureDataVO> getLectureDataList(int assign_num);
	public boolean deleteLectureData(int num);
	public LectureDataVO getLectureData(int num);
}
