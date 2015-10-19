package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public static final String regId = "doXCdgS40w4:APA91bGkKb_0qXh4MGnxT_YmuFxffN_EXVQXy5Ca1pb9T7TrLBtTSbSyQxcOCSB0y_df9R4vcuAlfaw0-4ZNCfYr-qopi8-ziio1kz_6KhREIrS63B4DvOWucCAYQzrbZ4FMfqWt_BMw";
	
	@RequestMapping("/GCMSend")
	public void sendPush(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		String appLogin = (String) request.getServletContext().getAttribute("appLogin");//(String)session.getAttribute("appLogin");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("GCMController:appLogin::::::::::::::::"+appLogin);
		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(appLogin);
		
		String fullPath;
		String lect_img[] = new String [20];
		String lect_name[] = new String [20];
		String lect_time[] = new String [20];
		String teacher_name[] = new String [20];
		String book_name[] = new String[20];
		
		SimpleDateFormat dateFormat = new  SimpleDateFormat("HH:mm E요일", java.util.Locale.getDefault());
		Date date = new Date();
		String strDate = dateFormat.format(date);
		System.out.println(strDate);
		
		Sender sender = new Sender(API_KEY);  //구글 코드에서 발급받은 서버 키
		   Message.Builder msg = new Message.Builder();		                                               
		
		int i=0;
		for(MemberClassVO v : memberClassList){
			fullPath = "http://117.17.143.126/BitProject/resources/upload/lectureImg/"+v.getLect_img();
			lect_img[i] = fullPath;
			lect_name[i] = v.getLect_name();
			lect_time[i] = v.getBeginTime()+" "+v.getDay();
			teacher_name[i] = v.getTeacher_name();
			book_name[i] = v.getBook_name();
			i++;
			
			if(strDate.equals(lect_time[i]))	{
				try	{
					msg.addData("lect_img", lect_img[i]);
					msg.addData("lect_name", lect_name[i]);
					msg.addData("book_name", book_name[i]);
					msg.addData("lect_time", lect_time[i]);
					
					Result result = sender.send(msg.build(), regId, 5);					//푸시 전송
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
