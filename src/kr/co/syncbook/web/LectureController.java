package kr.co.syncbook.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.BookService;
import kr.co.syncbook.biz.DataService;
import kr.co.syncbook.biz.LectureService;
import kr.co.syncbook.biz.SubjectService;
import kr.co.syncbook.vo.BookVO;
import kr.co.syncbook.vo.DataVO;
import kr.co.syncbook.vo.LectureVO;
import kr.co.syncbook.vo.NoticeVO;
import kr.co.syncbook.vo.SubjectVO;

@Controller
public class LectureController {
	@Autowired
	private LectureService lectureService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private BookService bookService;
	@Autowired
	private DataService dataService;

	@RequestMapping("/addLectureForm")
	public ModelAndView regLecture(){
		List<LectureVO> list = lectureService.getAllLecture();
		List<SubjectVO> sub_list = subjectService.getSubjectList();	
		ModelAndView mav = new ModelAndView();		
		mav.addObject("list", list);
		mav.addObject("subjectList", sub_list);
		mav.setViewName("addLectureForm");
		return mav;
	}
	@RequestMapping("/lectureDetail")
	public ModelAndView lectureDetail(int lect_num){
		List<DataVO> list = dataService.getDataList(lect_num);
		LectureVO lecture = lectureService.getLecture(lect_num);
		ModelAndView mav = new ModelAndView();		
		mav.addObject("dataList", list);
		mav.addObject("lecture", lecture);
		mav.setViewName("lectureDetail");
		return mav;
	}
	private static final int BUFFER_SIZE = 4096;
	@RequestMapping("data_fileDownload")
	public void Download(HttpServletRequest request,
            HttpServletResponse response, String data_file) throws IOException {
		String filepath = "/resources/upload/lectureData/"+data_file;
        // get absolute path of the application
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);
 
        // construct the complete absolute path of the file
        String fullPath = appPath + filepath;      
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
 
    }
	
	@RequestMapping("addData")
	public ModelAndView addData(DataVO data, HttpServletRequest request){
		String path = request.getRealPath("/resources/upload/lectureData");
		String upPath = path+"\\"+data.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			data.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		data.setData_file(data.getUpfile().getOriginalFilename());
		
		ModelAndView mav = new ModelAndView();
		boolean flag = dataService.addData(data);
		if(flag) {
			mav.setViewName("redirect:lectureDetail?lect_num="+data.getLect_num());
		} else {
			mav.setViewName("redirect:index");
		}
		return mav;
	}
	
	
	
	@RequestMapping("/selectBook")  
	public void selectBook(ServletResponse resp, @RequestParam int subj_num) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    List<BookVO> bookList = bookService.getSubjectBookList(subj_num);
	    out.print("<select name=\"book_num\" id=\"Book\">");
	    out.print("<option value=\"\">����</option>");
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
	@RequestMapping("/deleteData")
	public ModelAndView deleteData(int data_num){
		ModelAndView mav = new ModelAndView();
		DataVO data = dataService.getData(data_num);
		boolean flag = dataService.deleteData(data_num);
		if(flag) {
			mav.setViewName("redirect:lectureDetail?lect_num="+data.getLect_num());
		} else {
			mav.setViewName("redirect:lectureDetail?lect_num="+data.getLect_num());
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
