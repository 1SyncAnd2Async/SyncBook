package kr.co.syncbook.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.vo.BookVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.SubjectVO;

@Controller
public class LectureController {
	@Autowired
	private LectureService lectureService;
	@Autowired
	private SubjectService subjectService;
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
	@RequestMapping("/selectBook")  
	public void selectBook(ServletResponse resp, @RequestParam int subj_num) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    List<BookVO> bookList = bookService.getSubjectBookList(subj_num);
	    out.print("<select name=\"book_num\" id=\"Book\">");
	    out.print("<option value=\"\">º±≈√</option>");
	    for (BookVO book : bookList) {        
	        out.print("<option value=\"" + book.getBook_num() + "\">" + book.getBook_name() + "</option>");
	    }
	    out.print("</select>");
	    out.close();
	}
	@RequestMapping("/addLecture")
	public ModelAndView addLecture(LectureVO lecture, HttpServletRequest request){
		String path = request.getRealPath("/resources/upload/lectureImg");
		String upPath = path+"\\"+lecture.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			lecture.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		lecture.setImg(lecture.getUpfile().getOriginalFilename());
		ModelAndView mav = new ModelAndView();
		boolean flag = lectureService.addLecture(lecture);
		if(flag) {
			mav.setViewName("redirect:addLectureForm");
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
		ModelAndView mav = new ModelAndView();		
		mav.addObject("list", list);
		mav.addObject("subjectList", sub_list);
		mav.setViewName("lectureList");
		return mav;
	}
}
