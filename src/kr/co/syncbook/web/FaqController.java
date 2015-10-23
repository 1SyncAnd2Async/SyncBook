package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.FaqService;
import kr.co.syncbook.vo.FaqVO;
import kr.co.syncbook.vo.PageVO;

@Controller
public class FaqController {
	@Autowired
	FaqService faqService;
	
	@RequestMapping("faqList")
	public ModelAndView faqList(int page){
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 10; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 5; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = faqService.getFaqTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
		List<FaqVO> list = faqService.getFaqList();
		
		for(FaqVO v : list) {
			v.setWrite_date(v.getWrite_date().substring(0, 16));
		}
		
		ModelAndView mv = new ModelAndView("faqList");
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("faqList",list);
		return mv;
	}
	@RequestMapping("faqForm")
	public String writeForm(){
		return "faqForm";
	}
	@RequestMapping("faqUpdate")
	public ModelAndView updateForm(int faq_num){
		FaqVO faq =  faqService.getFaq(faq_num);
		ModelAndView mv = new ModelAndView("faqUpdate");
		mv.addObject("faq",faq);
		return mv;
	}
	@RequestMapping("faqUpdateOk")
	public String faqUpdateOk(FaqVO vo){	
	
		boolean flag=faqService.faqUpdate(vo);
		if(flag){
			return "redirect:faqList?page=1";
		}else{
			return "redirect:index";
		}
	}
	@RequestMapping("faqWrite")
	public String write(@ModelAttribute FaqVO vo){		
		
		boolean flag=faqService.faqUpload(vo);
		if(flag){
			return "redirect:faqList?page=1";
		}else{
			return "redirect:index";
		}
	}
	
	@RequestMapping("faqDetail")
	public ModelAndView faqDetail(int faq_num){
		
		faqService.faqHitUpdate(faq_num);
		FaqVO faq =  faqService.getFaq(faq_num);
		ModelAndView mv = new ModelAndView("faqDetail");
		mv.addObject("faqDetail", faq);
		return mv;
	}
	@RequestMapping("/faqDelete")
	public ModelAndView deleteSubject(int faq_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = faqService.faqDelete(faq_num);
		if(flag) {
			mav.setViewName("redirect:faqList?page=1");
		} else {
			mav.setViewName("redirect:faqList?page=1");
		}
		return mav;
	}
	
}
