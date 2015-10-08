package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.DataService;
import kr.co.syncbook.dao.DataDAO;
import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.QuestionVO;

@Service("dataService")
public class DataServiceImpl implements DataService {
	@Autowired
	private DataDAO dataDAO;
	@Override
	public boolean addData(DataVO data) {
		int result = dataDAO.addData(data);
		if(result==1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public List<DataVO> getDataList(int lect_num) {
		List<DataVO> dataList = dataDAO.getDataList(lect_num);
		return dataList;
	}
	@Override
	public boolean deleteData(int data_num) {
		int result = dataDAO.deleteData(data_num);
		if(result==1) return true;
		else return false;
	}
	@Override
	public DataVO getData(int data_num) {
		// TODO Auto-generated method stub
		return dataDAO.getData(data_num);
	}
}
