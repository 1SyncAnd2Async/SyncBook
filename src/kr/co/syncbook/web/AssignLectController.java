package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.AssignLectService;
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.vo.AssignLectVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.PageVO;
import kr.co.syncbook.vo.SubjectVO;
import kr.co.syncbook.vo.TeacherVO;

@Controller
public class AssignLectController {
	@Autowired
	private LectureService lectureService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private AssignLectService assignLectService;
	
	@RequestMapping("/assignLectureForm")
	public ModelAndView assignLectureForm(int page){
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
		int totalRows = assignLectService.getTotalCount();
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
		
		List<SubjectVO> subjectList = subjectService.getSubjectList();
		List<TeacherVO> teacherList = teacherService.getTeacherList();
		List<AssignLectVO> assignList = assignLectService.getAllAssignLectList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("subjectList", subjectList);
		mav.addObject("teacherList", teacherList);
		mav.addObject("assignList", assignList);
		mav.setViewName("assignLectureForm");
		return mav;
	}
	
	@RequestMapping("/selectLecture")  
	public void selectLecture(ServletResponse resp, @RequestParam int subj_num) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    List<LectureVO> lectureList = lectureService.getLectureList(subj_num);
	    out.print("<select name=\"lect_num\" id=\"Lecture\">");
	    out.print("<option value=\"\">����</option>");
	    for (LectureVO v : lectureList) {        
	        out.print("<option value=\"" + v.getLect_num() + "\">" + v.getLect_name() + "</option>");
	    }
	    out.print("</select>");
	    out.close();
	}
	
	@RequestMapping("/assignLecture")
	public ModelAndView assignLecture(AssignLectVO vo){
		ModelAndView mav = new ModelAndView();
		boolean flag = assignLectService.assignLect(vo);
		if(flag) {
			mav.setViewName("redirect:assignLectureForm");
		} else {
			mav.setViewName("redirect:index");
		}
		return mav;
	}
	@RequestMapping("/deleteAssignLect")
	public ModelAndView deleteAssignLect(AssignLectVO vo){
		ModelAndView mav = new ModelAndView();
		boolean flag = assignLectService.deleteAssignLect(vo);
		if(flag) {
			mav.setViewName("redirect:assignLectureForm");
		} else {
			mav.setViewName("redirect:index");
		}
		return mav;
	}
}