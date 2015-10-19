package kr.co.syncbook.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.syncbook.biz.MemberService;
import kr.co.syncbook.biz.RegLectService;
import kr.co.syncbook.vo.MemberVO;
import kr.co.syncbook.vo.OrderVO;
import kr.co.syncbook.vo.PageVO;

@Controller
//@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	RegLectService regLectService;
	
	
	
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
	public ModelAndView memberList(int page){
		
		PageVO pageInfo = new PageVO();
		int rowsPerPage = 10; // �� �������� ������ ��� �� - properties
		int pagesPerBlock = 3; // �� ��ϴ� ������ ������ �� - properties
		if (page == 0)
			page = 1; // ������ �ʱ�ȭ
		int currentPage = page; // ���� ������ ��
		int currentBlock = 0; // ���� ��� �ʱ�ȭ
		if (currentPage % pagesPerBlock == 0) { // ���� ��� �ʱ� ��
			currentBlock = currentPage / pagesPerBlock;
		} else { // ���� ����̳�
			currentBlock = currentPage / pagesPerBlock + 1;
		}
		int startRow = (currentPage - 1) * rowsPerPage; // ���� ��� �� ����
		int endRow = currentPage * rowsPerPage-1; // ������ ��� �� ����    
		// SearchVO�� ����
		// SearchVO svo = new SearchVO();
		// svo.setBegin(String.valueOf(startRow));
		// svo.setEnd(String.valueOf(endRow));
		// ��ü ������ ��
		int totalRows = memberService.getMemberTotalCount();
		// ��ü ������ ���ϴ� ����
		int totalPages = 0;
		if (totalRows % rowsPerPage == 0) {
			totalPages = totalRows / rowsPerPage;
		} else {
			totalPages = totalRows / rowsPerPage + 1;
		}
		// ��ü ��� ���� ���ϴ� ����
		int totalBlocks = 0;
		if (totalPages % pagesPerBlock == 0) {
			totalBlocks = totalPages / pagesPerBlock;
		} else {
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// ��� ����� ������ PageVO�� �����Ѵ�.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
		
		List<MemberVO> list = memberService.getMemberList();
		ModelAndView mv = new ModelAndView("memberList");
		mv.addObject("memberList",list);
		mv.addObject("pageInfo", pageInfo);
		return mv;
	}
	@RequestMapping("/memberDetail")
	public ModelAndView memberDetail(String id){
		List<OrderVO> list = regLectService.getOrderList(id);
		System.out.println(list);
		
		MemberVO member =  memberService.getMember(id);
		ModelAndView mv = new ModelAndView("memberDetail");
		mv.addObject("orderList", list);
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
			mav.setViewName("redirect:index");
		} else mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("member");
		return "redirect:index";
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
	public ModelAndView myPageForm(String member_id){
		List<OrderVO> list = regLectService.getOrderList(member_id);
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderList", list);
		mav.setViewName("myPageForm");
		return mav;
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
		// �������� ���
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
	public void Alogin(HttpSession session,HttpServletResponse response, HttpServletRequest request, String id, String password)	{
		ServletContext context = request.getServletContext();
		System.out.println(request.getServletContext());
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(id);
		System.out.println(password);
		
		MemberVO Amember = memberService.memberLogin(id, password);
		StringTokenizer stz = new StringTokenizer(Amember.getPost(), "-");
		String post1 = stz.nextToken();
		String post2 = stz.nextToken();
		
		PrintWriter out = null;
		
		System.out.println(Amember.getId());
		System.out.println(Amember.getPassword());
		System.out.println(Amember.getAddress());
		
		if(Amember != null)	{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("id", Amember.getId());
			jsonObject.put("password", Amember.getPassword());
			jsonObject.put("name", Amember.getName());
			jsonObject.put("phone", Amember.getPhone());
			jsonObject.put("post1", post1);
			jsonObject.put("post2", post2);
			jsonObject.put("address", Amember.getAddress());
			jsonObject.put("detail_address", Amember.getDetail_address());
			jsonObject.put("email", Amember.getEmail());
			System.out.println("appLogin:::::::::::::"+ Amember.getId());
			//session.setAttribute("appLogin", Amember.getId());
			context.setAttribute("appLogin", Amember.getId());
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