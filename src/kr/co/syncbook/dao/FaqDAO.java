package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.FaqVO;

public interface FaqDAO {
	public int addFaq(FaqVO vo);
	public int updateFaq(FaqVO vo);
	public int updateFaqHit(int faq_num);
	public int deleteFaq(int faq_num);
	public FaqVO getFaq(int faq_num);
	public List<FaqVO> getFaqList();
	public List<FaqVO> getFaqList(String searchKind, String searchValue);	
	public List<FaqVO> getMainFaqList();
	public List<FaqVO> getFaqSearchList(String searchKind, String searchValue);
	public int getFaqTotalCount();
}
