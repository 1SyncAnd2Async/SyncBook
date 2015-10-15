package kr.co.syncbook.web;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import kr.co.syncbook.biz.NoticeService;
import kr.co.syncbook.vo.NoticeVO;

@Controller
//@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList(){
		List<NoticeVO> list = noticeService.getNoticeList();
		ModelAndView mv = new ModelAndView("noticeList");
		mv.addObject("NoticeList",list);
		return mv;
	}
	@RequestMapping("noticeForm")
	public String writeForm(){
		return "noticeForm";
	}
	@RequestMapping("noticeUpdate")
	public ModelAndView updateForm(int notice_num){
		NoticeVO notice =  noticeService.getNotice(notice_num);
		ModelAndView mv = new ModelAndView("noticeUpdate");
		mv.addObject("notice",notice);
		return mv;
	}
	@RequestMapping("noticeUpdateOk")
	public String noticeUpdateOk(@ModelAttribute NoticeVO vo, HttpServletRequest request){		
		String path = request.getRealPath("/resources/upload/notice");
		String upPath = path+"\\"+vo.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			vo.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		vo.setNotice_file(vo.getUpfile().getOriginalFilename());
		
		boolean flag=noticeService.noticeUpdate(vo);
		if(flag){
			System.out.println("Notice Insert");
			return "redirect:noticeList";
		}else{
			System.out.println("Notice Insert Fail");
			return "redirect:index";
		}
	}
	@RequestMapping("noticeWrite")
	public String write(@ModelAttribute NoticeVO vo, HttpServletRequest request){		
		String path = request.getRealPath("/resources/upload/notice");
		String upPath = path+"\\"+vo.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			vo.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		vo.setNotice_file(vo.getUpfile().getOriginalFilename());
		
		boolean flag=noticeService.noticeUpload(vo);
		if(flag){
			System.out.println("Notice Insert");
			return "redirect:index";
		}else{
			System.out.println("Notice Insert Fail");
			return "redirect:index";
		}
	}
	
	
	
	@RequestMapping("noticeDetail")
	public ModelAndView noticeDetail(int notice_num){
		
		noticeService.noticeHitUpdate(notice_num);
		NoticeVO notice =  noticeService.getNotice(notice_num);
		ModelAndView mv = new ModelAndView("noticeDetail");
		mv.addObject("NoticeDetail", notice);
		
		return mv;
	}
	
	private static final int BUFFER_SIZE = 4096;
	@RequestMapping("noticeFileDownload")
	public void Download(HttpServletRequest request,
            HttpServletResponse response, String notice_file) throws IOException {
		String filepath = "/resources/upload/notice/"+notice_file;
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
	@RequestMapping("noticeSearchList")
	public ModelAndView noticeSearchList(@PathVariable String searchKind, String searchValue){
		System.out.println("searchKind : "+searchKind+"   searchValue"+searchValue);
		List<NoticeVO> list = noticeService.getNoticeSearchList(searchKind, searchValue);
		ModelAndView mv = new ModelAndView("noticeList");
		mv.addObject("NotciceSearchList",list);
		return mv;
	}
	@RequestMapping("/deleteNotice")
	public ModelAndView deleteSubject(int notice_num){
		ModelAndView mav = new ModelAndView();
		boolean flag = noticeService.noticeDelete(notice_num);
		if(flag) {
			mav.setViewName("redirect:noticeList");
		} else {
			mav.setViewName("redirect:noticeList");
		}
		return mav;
	}
	

}
