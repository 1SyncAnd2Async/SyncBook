package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;

public interface DataService {
	public boolean addData(DataVO vo);
	public List<DataVO> getDataList(int lect_num);
	public boolean deleteData(int data_num);
	public DataVO getData(int data_num);
}
