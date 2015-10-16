package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.QnaService;
import kr.co.syncbook.dao.QnaDAO;
import kr.co.syncbook.vo.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{

	@Autowired 
	QnaDAO qnaDAO;
	@Override
	public boolean qnaUpload(QnaVO vo) {
		int result = qnaDAO.addQna(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean qnaUpdate(QnaVO vo) {
		int result = qnaDAO.updateQna(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean qnaDelete(int qna_num) {
		int result = qnaDAO.deleteQna(qna_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public QnaVO getQna(int qna_num) {
		QnaVO qna  = qnaDAO.getQna(qna_num);
		return qna;
	}

	@Override
	public List<QnaVO> getQnaList() {
		
		List<QnaVO> list = qnaDAO.getQnaList();
		return list;
	}

	@Override
	public List<QnaVO> getqnaSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<QnaVO> list = qnaDAO.getQnaSearchList(searchKind, searchValue);
		return list;
	}

	@Override
	public List<QnaVO> getMainQnaList() {
		List<QnaVO> list = qnaDAO.getMainQnaList();
		return list;
	}

	@Override
	public boolean qnaHitUpdate(int qna_num) {
		int result = qnaDAO.updateQnaHit(qna_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int getQnaTotalCount() {
		return qnaDAO.getQnaTotalCount();
	}

}
