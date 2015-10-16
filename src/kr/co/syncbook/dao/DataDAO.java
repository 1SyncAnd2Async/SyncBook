package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;

public interface DataDAO {
	public int addData(DataVO vo);
	public List<DataVO> getDataList(int lect_num);
	public DataVO getData(int data_num);
	public int deleteData(int data_num);	
}
