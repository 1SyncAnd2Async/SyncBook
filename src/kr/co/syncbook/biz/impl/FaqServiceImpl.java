package kr.co.syncbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.syncbook.biz.FaqService;
import kr.co.syncbook.dao.FaqDAO;
import kr.co.syncbook.vo.FaqVO;

@Service("FaqService")
public class FaqServiceImpl implements FaqService{

	@Autowired 
	FaqDAO faqDAO;
	@Override
	public boolean faqUpload(FaqVO vo) {
		int result = faqDAO.addFaq(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean faqUpdate(FaqVO vo) {
		int result = faqDAO.updateFaq(vo);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean faqDelete(int faq_num) {
		int result = faqDAO.deleteFaq(faq_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public FaqVO getFaq(int faq_num) {
		FaqVO faq  = faqDAO.getFaq(faq_num);
		return faq;
	}

	@Override
	public List<FaqVO> getFaqList() {
		
		List<FaqVO> list = faqDAO.getFaqList();
		return list;
	}

	@Override
	public List<FaqVO> getFaqSearchList(String searchKind, String searchValue) {
		System.out.println(searchKind+searchValue);
		List<FaqVO> list = faqDAO.getFaqSearchList(searchKind, searchValue);
		return list;
	}

	@Override
	public List<FaqVO> getMainFaqList() {
		List<FaqVO> list = faqDAO.getMainFaqList();
		return list;
	}

	@Override
	public boolean faqHitUpdate(int faq_num) {
		int result = faqDAO.updateFaqHit(faq_num);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}

}
