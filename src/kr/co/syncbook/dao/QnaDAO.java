package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.QnaVO;

public interface QnaDAO {
	public int addQna(QnaVO vo);
	public int updateQna(QnaVO vo);
	public int updateQnaHit(int qna_num);
	public int deleteQna(int qna_num);
	public QnaVO getQna(int qna_num);
	public List<QnaVO> getQnaList();
	public List<QnaVO> getQnaList(String searchKind, String searchValue);	
	public List<QnaVO> getMainQnaList();
	public List<QnaVO> getQnaSearchList(String searchKind, String searchValue);
}
