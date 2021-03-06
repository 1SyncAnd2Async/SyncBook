package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.QnaVO;

public interface QnaService {
	public boolean qnaUpload(QnaVO vo);
	public boolean qnaUpdate(QnaVO vo);
	public boolean qnaHitUpdate(int qna_num);
	public boolean qnaDelete(int qna_num);
	public QnaVO getQna(int qna_num);
	public List<QnaVO> getQnaList();
	public List<QnaVO> getMainQnaList();
	public List<QnaVO> getqnaSearchList(String searchKind, String searchValue);
	public int getQnaTotalCount();
}
