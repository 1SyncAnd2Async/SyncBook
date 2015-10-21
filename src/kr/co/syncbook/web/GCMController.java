package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.MemberClassVO;
import kr.co.syncbook.vo.MemberVO;

@Controller
public class GCMController {
	@Autowired
	private RegLectService regLectService;
	
	public static final String API_KEY = "AIzaSyCkO62bcjhrcPC36HvMRigpFKOdo-gak2k";
	
	private Sender sender;
	private Message msg;
	
	@RequestMapping("/GCMSend")
	public void sendPush(String regId, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(regId);
//		HttpSession session = request.getSession();
//		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		String appLogin = (String) request.getServletContext().getAttribute("appLogin");//(String)session.getAttribute("appLogin");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("GCMController:appLogin::::::::::::::::"+appLogin);
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(appLogin);
				
		SimpleDateFormat dateFormat = new  SimpleDateFormat("HH:mm E요일", java.util.Locale.getDefault());
		Date date = new Date();
		String strDate = dateFormat.format(date);
		System.out.println(strDate);
		
		sender = new Sender(API_KEY);  //구글 코드에서 발급받은 서버 키
		   Message.Builder builder = new Message.Builder();		                                               
		
		for(MemberClassVO v : memberClassList){
			String fullPath = "http://117.17.143.126/BitProject/resources/upload/lectureImg/"+v.getLect_img();
			String lect_img = fullPath;
			String lect_name = v.getLect_name();
			String lect_time = v.getBeginTime()+" "+v.getDay();
			String teacher_name = v.getTeacher_name();
			String book_name = v.getBook_name();
			
			if(strDate.equals("22:02 수요일"))	{
				try	{
					builder.addData("lect_img", lect_img);
					builder.addData("lect_name", lect_name);
					builder.addData("book_name", book_name);
					builder.addData("lect_time", lect_time);
					
					msg = builder.build();
					
					System.out.println(regId);
					System.out.println(msg);
					Result result = sender.send(msg, regId, 5);					//푸시 전송
					System.out.println(msg);
					String error = result.getErrorCodeName();					//에러코드
					String msgId = result.getMessageId();						//푸시 메시지 id
					
					request.setAttribute("error", error);							//에러메시지 저장
					request.setAttribute("msgId", msgId);
				}catch(Exception e)	{
					e.printStackTrace();
				}
			}
		}
		



		
		   
		}

}
