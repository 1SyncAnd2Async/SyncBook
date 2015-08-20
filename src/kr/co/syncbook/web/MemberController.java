package kr.co.syncbook.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.vo.MemberVO;

@Controller
//@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "loginForm";
	}
	@RequestMapping("/joinForm")
	public String joinForm(){
		return "joinForm";
	}
	@RequestMapping("/userSerch")
	public String userSerch(){
		return "userSerch()";
	}
	@RequestMapping("/login")
	public ModelAndView login(String id, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.memberLogin(id, password);
		if(flag) {
			session.setAttribute("id", id);
			mav.setViewName("index");
		}
		else mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		return "index";
	}
	@RequestMapping("/join")
	public ModelAndView join(MemberVO member, @RequestParam String post1, @RequestParam String post2) {
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.memberJoin(member, post1, post2);
		if(flag) {
			mav.setViewName("loginForm");
		}
		else {
			mav.setViewName("joinForm");
		}
		return mav;
	}
	@RequestMapping("/idCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam String memberId) throws IOException {
		boolean flag = memberService.idCheck(memberId);
		String result = null;
		PrintWriter out = response.getWriter();
		if(flag) result = "fail";
		else result = "success";
		out.print(result);
		out.close();
	}
}
