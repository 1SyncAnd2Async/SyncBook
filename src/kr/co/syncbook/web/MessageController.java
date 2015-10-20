package kr.co.syncbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.biz.MessageService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.MessageVO;
import kr.co.syncbook.vo.PageVO;

@Controller
public class MessageController {
	@Autowired
	MessageService messageService;
	@Autowired
	MemberService memberService;
	@Autowired
	RegLectService regLectService;
	
	@RequestMapping("messageList")
	public ModelAndView messageList(int page, String receiver){
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
		int totalRows = messageService.getMessageTotalCount();
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
		System.out.println(receiver);
		List<MessageVO> list = messageService.getReceiveMessageList(receiver);
		System.out.println(list);
		ModelAndView mv = new ModelAndView("messageList");
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("messageList",list);
		return mv;
	}
	@RequestMapping("messageForm")
	public ModelAndView messageForm(int reg_num, String id){
		MemberClassVO memberClassDetail;
		MemberClassVO vo = new MemberClassVO();
		vo.setReg_num(reg_num);
		if(memberService.idCheck(id)) {
			vo.setMember_id(id);
			memberClassDetail = regLectService.getMemberClassDetail(vo);
		} else {
			vo.setTeacher_id(id);
			memberClassDetail = regLectService.getTeacherClassDetail(vo);
		}
		System.out.println(memberClassDetail);
		ModelAndView mv = new ModelAndView("messageForm");
		mv.addObject("memberClassDetail", memberClassDetail);
		return mv;
	}
	@RequestMapping("/messageDelete")
	public ModelAndView deleteSubject(int message_num, String id){
		ModelAndView mav = new ModelAndView();
		boolean flag = messageService.messageDelete(message_num);
		if(flag) {
			mav.setViewName("redirect:messageList?page=1&receiver="+id);
		} else {
			mav.setViewName("redirect:messageList?page=1&receiver="+id);
		}
		return mav;
	}
	@RequestMapping("messageWrite")
	public String write(@ModelAttribute MessageVO vo){		
		
		boolean flag=messageService.messageUpload(vo);
		if(flag){
			System.out.println("message Insert");
			return "redirect:messageList?page=1&receiver="+vo.getSender();
		}else{
			System.out.println("message Insert Fail");
			return "redirect:index";
		}
	}
	
	@RequestMapping("messageDetail")
	public ModelAndView messageDetail(int message_num){
		
		
		MessageVO message =  messageService.getMessage(message_num);
		if(message.getStatus()==0){
			messageService.messageStatusUpdate(message_num);
		}
		ModelAndView mv = new ModelAndView("messageDetail");
		mv.addObject("messageDetail", message);
		return mv;
	}
	

}