package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
public class GCMController {
	@Autowired
	private RegLectService regLectService;
	
	public static final String API_KEY = "AIzaSyCkO62bcjhrcPC36HvMRigpFKOdo-gak2k";
	public static final String regId = "doXCdgS40w4:APA91bGkKb_0qXh4MGnxT_YmuFxffN_EXVQXy5Ca1pb9T7TrLBtTSbSyQxcOCSB0y_df9R4vcuAlfaw0-4ZNCfYr-qopi8-ziio1kz_6KhREIrS63B4DvOWucCAYQzrbZ4FMfqWt_BMw";
	
	@RequestMapping("/GCMSend")
	public void sendPush(String member_id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		
//		System.out.println(member_id);
//		List<MemberClassVO> memberClassList = regLectService.getMemberClassList(member_id);
//		
//		String fullPath;
//		String lect_img[] = new String [20];
//		String lect_name[] = new String [20];
//		String lect_time[] = new String [20];
//		String teacher_name[] = new String [20];
		
		SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault());
		Date date = new Date();
		String strDate = dateFormat.format(date);
		System.out.println(strDate);
		
//		int i=0;
//		for(MemberClassVO v : memberClassList){
//			fullPath = "http://117.17.143.126/BitProject/resources/upload/lectureImg/"+v.getLect_img();
//			lect_img[i] = fullPath;
//			lect_name[i] = v.getLect_name();
//			lect_time[i] = v.getBeginTime();
//			teacher_name[i] = v.getTeacher_name();
//			i++;
//		}
		

		try {
			Date date1 = dateFormat.parse(strDate);
			Date date2 = dateFormat.parse("2015-10-16 01:35");
			
			if(date1.equals(date2))	{
				Sender sender = new Sender(API_KEY);  //구글 코드에서 발급받은 서버 키
				   Message msg = new Message.Builder()
				                                               .addData("title", "hihihi")  //데이터 추가
				                                               .addData("message", "하하하하")  //데이터 추가
				                                               .build();

				   
				   
						Result result = sender.send(msg, regId, 5);					//푸시 전송
						System.out.println(msg);
						String error = result.getErrorCodeName();					//에러코드
						String msgId = result.getMessageId();						//푸시 메시지 id
						
						request.setAttribute("error", error);							//에러메시지 저장
						request.setAttribute("msgId", msgId);						//푸시 메시지 id 저장
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		   
		}

}
