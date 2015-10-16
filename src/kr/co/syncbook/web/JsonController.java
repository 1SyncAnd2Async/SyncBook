package kr.co.syncbook.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsonController {
   
   @RequestMapping("/json")
   public void json(HttpServletResponse response, HttpServletRequest request, String jsonName)   {
	   
	  
//	  response.setContentType("application/json; charset=UTF-8");
//	  response.setCharacterEncoding("UTF-8");

      PrintWriter out = null;
      HttpURLConnection connection = null;

      try {
    	 request.setCharacterEncoding("UTF-8");
    	  
         out = response.getWriter();
         
         URL url = new URL("http://117.17.143.126/BitProject/resources/upload/questionJson/"+jsonName);
         System.out.println(url);
         connection = (HttpURLConnection) url.openConnection();
         connection.setRequestProperty("Accept-Charset", "UTF-8");
         connection.connect();
         
         response.setContentType("application/json; charset=UTF-8");
   	  	 response.setCharacterEncoding("UTF-8");
         
         request.setCharacterEncoding("UTF-8");
         
         
         BufferedReader reader = new BufferedReader(
                 new InputStreamReader(connection.getInputStream(), "UTF-8"));
             StringBuilder builder = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null)
             {
            	 System.out.print(line);
                 builder.append(line);
             }
             System.out.println(builder.toString());
         
         org.json.JSONObject jsonObject = new org.json.JSONObject(builder.toString());
         
         System.out.println(jsonObject.toString());
         
         out.println(jsonObject.toString());
         out.close();
    
    
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
    	  connection.disconnect();
	}
   }

}
