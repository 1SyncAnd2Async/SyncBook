package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.FaqVO;

public interface FaqService {
	public boolean faqUpload(FaqVO vo);
	public boolean faqUpdate(FaqVO vo);
	public boolean faqHitUpdate(int faq_num);
	public boolean faqDelete(int faq_num);
	public FaqVO getFaq(int faq_num);
	public List<FaqVO> getFaqList();
	public List<FaqVO> getMainFaqList();
	public List<FaqVO> getFaqSearchList(String searchKind, String searchValue);
	public int getFaqTotalCount();
}
