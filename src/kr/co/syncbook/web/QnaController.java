package kr.co.syncbook.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64.Encoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import kr.co.syncbook.biz.QnaService;
import kr.co.syncbook.vo.QnaVO;

@Controller
public class QnaController {
	@Autowired
	QnaService QnaService;
	
	@RequestMapping("qnaList")
	public ModelAndView QnaList(){
		List<QnaVO> list = QnaService.getQnaList();
		ModelAndView mv = new ModelAndView("qnaList");
		mv.addObject("qnaList",list);
		return mv;
	}
	@RequestMapping("qnaForm")
	public String writeForm(){
		return "qnaForm";
	}
	@RequestMapping("qnaUpdate")
	public ModelAndView updateForm(int qna_num){
		QnaVO qna =  QnaService.getQna(qna_num);
		ModelAndView mv = new ModelAndView("qnaUpdate");
		mv.addObject("qna",qna);
		return mv;
	}
	@RequestMapping("qnaUpdateOk")
	public String qnaUpdateOk(QnaVO vo, HttpServletRequest request){	
		String path = request.getRealPath("/resources/upload/qna");
		String upPath = path+"\\"+vo.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			vo.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		vo.setQna_file(vo.getUpfile().getOriginalFilename());
		boolean flag=QnaService.qnaUpdate(vo);
		if(flag){
			System.out.println("Qna Insert");
			return "redirect:qnaList";
		}else{
			System.out.println("Qna Insert Fail");
			return "redirect:index";
		}
	}
	@RequestMapping("qnaWrite")
	public String write(@ModelAttribute QnaVO vo, HttpServletRequest request){		
		String path = request.getRealPath("/resources/upload/qna");
		String upPath = path+"\\"+vo.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			vo.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		vo.setQna_file(vo.getUpfile().getOriginalFilename());
		
		boolean flag=QnaService.qnaUpload(vo);
		if(flag){
			System.out.println("Qna Insert");
			return "redirect:qnaList";
		}else{
			System.out.println("Qna Insert Fail");
			return "redirect:index";
		}
	}
	
	@RequestMapping("qnaDetail")
	public ModelAndView QnaDetail(int qna_num){
		
		QnaService.qnaHitUpdate(qna_num);
		QnaVO qna =  QnaService.getQna(qna_num);
		ModelAndView mv = new ModelAndView("qnaDetail");
		mv.addObject("qnaDetail", qna);
		return mv;
	}
	
	private static final int BUFFER_SIZE = 4096;
	@RequestMapping("qnaFileDownload")
	public void Download(HttpServletRequest request,
            HttpServletResponse response, String qna_file) throws IOException {
		System.out.println(qna_file);
		String filepath = "/resources/upload/qna/"+qna_file;
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
        response.setCharacterEncoding("UTF-8");
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
	

}
