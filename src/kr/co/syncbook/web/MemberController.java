package kr.co.syncbook.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

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
	public ModelAndView loginForm(String login){
		System.out.println(login);
		ModelAndView mav = new ModelAndView();
		mav.addObject("login", login);
		mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping("/memberJoinForm")
	public String joinForm(){
		return "memberJoinForm";
	}
	@RequestMapping("/loginOption")
	public String loginOption(){
		return "loginOption";
	}
	@RequestMapping("/joinOption")
	public String joinOption(){
		return "joinOption";
	}
	@RequestMapping("/userSerch")
	public String userSerch(){
		return "userSerch";
	}
	@RequestMapping("/memberList")
	public ModelAndView memberList(){
		List<MemberVO> list = memberService.getMemberList();
		ModelAndView mv = new ModelAndView("memberList");
		mv.addObject("memberList",list);
		return mv;
	}
	@RequestMapping("/memberDetail")
	public ModelAndView memberDetail(String id){
		MemberVO member =  memberService.getMember(id);
		ModelAndView mv = new ModelAndView("memberDetail");
		mv.addObject("member", member);
		
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(String id, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberVO member = memberService.memberLogin(id, password);
		StringTokenizer stz = new StringTokenizer(member.getPost(), "-");
		String post1 = stz.nextToken();
		String post2 = stz.nextToken();
		if(member != null) {
			session.setAttribute("member", member);
			session.setAttribute("post1", post1);
			session.setAttribute("post2", post2);
			mav.setViewName("index");
		} else mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("member");
		return "index";
	}
	@RequestMapping("/memberJoin")
	public ModelAndView join(MemberVO member, @RequestParam String post1, @RequestParam String post2) {
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.memberJoin(member, post1, post2);
		if(flag) {
			mav.setViewName("loginForm");
		} else {
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
	@RequestMapping("/myPageForm")
	public String myPageForm(){
		return "myPageForm";
	}
	@RequestMapping("/updateMemberProfile")
	public ModelAndView updateMemberProfile(MemberVO member, @RequestParam String post1, @RequestParam String post2, HttpSession session, HttpServletRequest request) {
		String path = request.getRealPath("/resources/upload/memberImg");
		String upPath = path+"\\"+member.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			member.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		member.setImg(member.getUpfile().getOriginalFilename());
		ModelAndView mav = new ModelAndView();
		MemberVO vo = (MemberVO) session.getAttribute("member");
		member.setId(vo.getId());
		boolean flag = memberService.updateMemberProfile(member, post1, post2);
		if(flag) {
			session.setAttribute("post1", post1);
			session.setAttribute("post2", post2);
			session.setAttribute("member", member);
			mav.addObject("msg", "변경 완료");
			mav.setViewName("myPageForm");
		} else {
			mav.addObject("msg", "변경 실패");
			mav.setViewName("myPageForm");
		}
		return mav;
	}
	@RequestMapping("/pwdCheck")
	public void pwdCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam String memberPwd) throws IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String memberId = member.getId();
		boolean flag = memberService.pwdCheck(memberId, memberPwd);
		String result = null;
		PrintWriter out = response.getWriter();
		if(flag) result = "success";
		else result = "fail";
		out.print(result);
		out.close();
	}
	
	@RequestMapping("/updateMemberPwd")
	public ModelAndView updateMemberPwd(@RequestParam String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		member.setPassword(password);
		ModelAndView mav = new ModelAndView();
		boolean flag = memberService.updateMemberPwd(member);
		if(flag) {
			// 팝업으로!
			mav.setViewName("myPageForm");
		} else {
			mav.addObject("msg", "변경 실패");
			mav.setViewName("myPageForm");
		}
		return mav;
	}
	
}