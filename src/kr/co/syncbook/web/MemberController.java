package kr.co.syncbook.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("login")
	public ModelAndView login(String id, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.memberLogin(id, password);
		if(flag) {
			session.setAttribute("id", id);
			mav.setViewName("index");
		}
		else mav.setViewName("member/login");
		return mav;
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("id");
		return "index";
	}
	
	@RequestMapping("join")
	public ModelAndView join(MemberVO member) {
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.memberJoin(member);
		if(flag) mav.setViewName("member/login");
		else mav.setViewName("member/join");
		return mav;
	}
}
