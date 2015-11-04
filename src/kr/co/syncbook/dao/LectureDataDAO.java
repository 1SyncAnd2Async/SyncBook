package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureDataVO;

public interface LectureDataDAO {
	public int addLectureData(LectureDataVO vo);
	public List<LectureDataVO> getLectureDataList(int assign_num);
	public LectureDataVO getLectureData(int num);
	public int deleteLectureData(int num);	
}
