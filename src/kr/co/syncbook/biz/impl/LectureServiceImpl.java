package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.dao.LectureDAO;
import kr.co.syncbook.vo.LectureVO;

@Service("lectureService")
public class LectureServiceImpl implements LectureService{
	@Autowired
	LectureDAO lectureDAO;

	@Override
	public boolean addLecture(LectureVO vo) {
		int result = lectureDAO.addLecture(vo);
		if(result==1) return true;
		else return false;
		
	}

	@Override
	public boolean updateLecture(LectureVO vo) {
		int result = lectureDAO.updateLecture(vo);
		if(result==1) return true;
		else return false;
	}

	@Override
	public boolean deleteLecture(int lect_num) {
		int result = lectureDAO.deleteLecture(lect_num);
		if(result==1) return true;
		else return false;
	}

	@Override
	public LectureVO getLecture(int lect_num) {
		// TODO Auto-generated method stub
		return lectureDAO.getLecture(lect_num);
	}

	@Override
	public List<LectureVO> getAllLectureList() {
		// TODO Auto-generated method stub
		List<LectureVO> list = lectureDAO.getAllLectureList();
		return list;
	}

	@Override
	public List<LectureVO> getLectureList(int subj_num) {
		List<LectureVO> list = lectureDAO.getLectureList(subj_num);
		return list;
	}
	
}
