package kr.co.syncbook.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.dao.MemberDAO;
import kr.co.syncbook.dao.impl.MemberDAOImpl;
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
			mav.setViewName("redirect:loginForm?login=login");
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
			mav.addObject("msg", "���� �Ϸ�");
			mav.setViewName("myPageForm");
		} else {
			mav.addObject("msg", "���� ����");
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
			// �˾�����!
			mav.setViewName("myPageForm");
		} else {
			mav.addObject("msg", "���� ����");
			mav.setViewName("myPageForm");
		}
		return mav;
	}
	
	@RequestMapping("/androidMemberJoin")
	public void Ajoin(HttpServletRequest request, @RequestParam String post1, @RequestParam String post2)	{
		// 폼데이터 얻기
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		member.setDetail_address(request.getParameter("detail_address"));
		member.setEmail(request.getParameter("email"));
	
		memberService.memberJoin(member, post1, post2);
	}
	
	@RequestMapping("/androidLogin")
	public void Alogin(HttpServletResponse response, HttpServletRequest request, String id, String password)	{
		
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(id);
		System.out.println(password);
		
		MemberVO member = memberService.memberLogin(id, password);
		StringTokenizer stz = new StringTokenizer(member.getPost(), "-");
		String post1 = stz.nextToken();
		String post2 = stz.nextToken();
		
		PrintWriter out = null;
		
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getAddress());
		
		if(member != null)	{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("id", member.getId());
			jsonObject.put("password", member.getPassword());
			jsonObject.put("name", member.getName());
			jsonObject.put("phone", member.getPhone());
			jsonObject.put("post1", post1);
			jsonObject.put("post2", post2);
			jsonObject.put("address", member.getAddress());
			jsonObject.put("detail_address", member.getDetail_address());
			jsonObject.put("email", member.getEmail());
			
			try {
				out = response.getWriter();
				
				out.println(jsonObject.toJSONString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(jsonObject.toJSONString());
		}
	}
	
}