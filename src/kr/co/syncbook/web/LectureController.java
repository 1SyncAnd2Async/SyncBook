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

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.vo.BookVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.SubjectVO;
import kr.co.syncbook.vo.TeacherVO;

@Controller
public class LectureController {
	@Autowired
	private LectureService lectureService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private BookService bookService;

	@RequestMapping("/addLectureForm")
	public ModelAndView regLecture(){
		List<LectureVO> list = lectureService.getAllLectureList();
		List<SubjectVO> sub_list = subjectService.getSubjectList();	

		ModelAndView mav = new ModelAndView();		
		mav.addObject("list", list);
		mav.addObject("subjectList", sub_list);
		mav.setViewName("addLectureForm");
		return mav;
	}
	@RequestMapping("/assignLectureForm")
	public ModelAndView assignLecture(){
		List<SubjectVO> subjectList = subjectService.getSubjectList();
		List<TeacherVO> teacherList = teacherService.getTeacherList();
		ModelAndView mav = new ModelAndView();		
		mav.addObject("subjectList", subjectList);
		mav.addObject("teacherList", teacherList);
		mav.setViewName("assignLectureForm");
		return mav;
	}
	@RequestMapping("/selectBook")  
	public void selectBook(ServletResponse resp, @RequestParam int subj_num) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    List<BookVO> bookList = bookService.getSubjectBookList(subj_num);
	    out.print("<select name=\"book_num\" id=\"Book\">");
	    out.print("<option value=\"\">선택</option>");
	    for (BookVO book : bookList) {        
	        out.print("<option value=\"" + book.getBook_num() + "\">" + book.getBook_name() + "</option>");
	    }
	    out.print("</select>");
	    out.close();
	}
	@RequestMapping("/selectLecture")  
	public void selectLecture(ServletResponse resp, @RequestParam int subj_num) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    List<LectureVO> lectureList = lectureService.getLectureList(subj_num);
	    out.print("<select name=\"lect_num\" id=\"Lecture\">");
	    out.print("<option value=\"\">선택</option>");
	    for (LectureVO v : lectureList) {        
	        out.print("<option value=\"" + v.getLect_num() + "\">" + v.getLect_name() + "</option>");
	    }
	    out.print("</select>");
	    out.close();
	}
	@RequestMapping("/addLecture")
	public ModelAndView regLecture(LectureVO vo){
		ModelAndView mav = new ModelAndView();
		System.out.println(vo);
		boolean flag = lectureService.addLecture(vo);
		if(flag) {
			mav.setViewName("redirect:addLectureForm");
		} else {
			mav.setViewName("redirect:index");
		}
		return mav;
	}
	@RequestMapping("/assignLecture")
	public ModelAndView assignLecture(LectureVO vo){
		ModelAndView mav = new ModelAndView();
		System.out.println(vo);
		boolean flag = lectureService.addLecture(vo);
		if(flag) {
			mav.setViewName("redirect:assignLectureForm");
		} else {
			mav.setViewName("redirect:index");
		}
		return mav;
	}
	@RequestMapping("/deleteLecture")
	public ModelAndView deleteLecture(int lect_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = lectureService.deleteLecture(lect_num);
		if(flag) {
			mav.setViewName("redirect:lecture");
		} else {
			mav.setViewName("redirect:lecture");
		}
		return mav;
	}
	@RequestMapping("/lectureList")
	public ModelAndView lectureList(){
		List<LectureVO> list = lectureService.getAllLectureList();
		List<SubjectVO> sub_list = subjectService.getSubjectList();
		System.out.println(list);
		ModelAndView mav = new ModelAndView();		
		mav.addObject("list", list);
		mav.addObject("subjectList", sub_list);
		mav.setViewName("lectureList");
		return mav;
	}
}
