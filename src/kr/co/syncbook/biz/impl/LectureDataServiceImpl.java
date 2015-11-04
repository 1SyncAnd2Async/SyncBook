package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.LectureDataService;
import kr.co.syncbook.dao.LectureDataDAO;
import kr.co.syncbook.vo.LectureDataVO;

@Service("lectureDataService")
public class LectureDataServiceImpl implements LectureDataService {
	@Autowired
	private LectureDataDAO lectureDataDAO;
	@Override
	public boolean addLectureData(LectureDataVO vo) {
		int result = lectureDataDAO.addLectureData(vo);
		if(result==1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public List<LectureDataVO> getLectureDataList(int assign_num) {
		List<LectureDataVO> dataList = lectureDataDAO.getLectureDataList(assign_num);
		return dataList;
	}
	@Override
	public boolean deleteLectureData(int num) {
		int result = lectureDataDAO.deleteLectureData(num);
		if(result==1) return true;
		else return false;
	}
	@Override
	public LectureDataVO getLectureData(int num) {
		// TODO Auto-generated method stub
		return lectureDataDAO.getLectureData(num);
	}
}
