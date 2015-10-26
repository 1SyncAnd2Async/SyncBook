package kr.co.syncbook.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.CloudRecognition.PostNewTarget;
import kr.co.syncbook.biz.QuestionService;
import kr.co.syncbook.vo.QuestionVO;

@Controller
public class QuestionController {
   @Autowired
   private QuestionService questionService;
   @RequestMapping(value="/regQuestion", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
   public ModelAndView uploadQuestion(QuestionVO question, HttpServletRequest request, HttpServletResponse response){
      String path = request.getRealPath("/resources/upload/questionImg");
      String upPath = path+"\\"+question.getUpImg().getOriginalFilename();
      File f = new File(upPath);
      try {
         question.getUpImg().transferTo(f);
      } catch (IllegalStateException | IOException e) {
         e.printStackTrace();
      }
      question.setContent(question.getUpImg().getOriginalFilename());
      
      String path2 = request.getRealPath("/resources/upload/questionVideo");
      String upPath2 = path2+"\\"+question.getUpVideo().getOriginalFilename();
      File f2 = new File(upPath2);
      try {
         question.getUpVideo().transferTo(f2);
      } catch (IllegalStateException | IOException e) {
         e.printStackTrace();
      }
      question.setQuestion_file(question.getUpVideo().getOriginalFilename());
      
      StringBuffer sb = new StringBuffer();
      sb.append(question.getBook_num()+"-"+question.getUnit_num()+"-"+question.getQuestion_num());
      
      // DB 저장
      boolean flag = questionService.addQuestion(question);
      
      // Vuforia Cloud 저장
      try {
         PostNewTarget p = new PostNewTarget(sb.toString(), upPath, sb.toString());
         p.postTargetThenPollStatus();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      JSONObject obj = new JSONObject();
      response.setCharacterEncoding("UTF-8");
      try {
         obj.put("explanation", question.getExplanation());
         obj.put("question_file", "http://117.17.143.126/BitProject/resources/upload/questionVideo/"+question.getQuestion_file());
         String jsonPath = request.getRealPath("resources/upload/questionJson");
         FileWriter fw = new FileWriter(jsonPath + "\\" + sb + ".json");
         fw.write(obj.toJSONString());
         fw.flush();
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      ModelAndView mav = new ModelAndView();
      if(flag) {
         mav.addObject("msg", "success");
         mav.setViewName("redirect:bookDetail?book_num="+question.getBook_num());
      } else {
         mav.setViewName("redirect:bookDetail?book_num"+question.getBook_num());
      }
      return mav;
   }
}