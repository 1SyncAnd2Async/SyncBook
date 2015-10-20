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

import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.vo.TeacherVO;

@Controller
//@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/teacherPageForm")
	public String teacherPageForm(){
		return "teacherPageForm";
	}
	@RequestMapping("/teacherJoinForm")
	public String teacherJoinForm(){
		return "teacherJoinForm";
	}
	@RequestMapping("/teacherList")
	public ModelAndView teacherList(){
		List<TeacherVO> list = teacherService.getTeacherList();
		ModelAndView mv = new ModelAndView("teacherList");
		mv.addObject("teacherList",list);
		return mv;
	}
	@RequestMapping("/teacherDetail")
	public ModelAndView teacherDetail(String id){
		TeacherVO teacher =  teacherService.getTeacher(id);
		ModelAndView mv = new ModelAndView("teacherDetail");
		mv.addObject("teacher", teacher);
		
		return mv;
	}

	@RequestMapping("/teacherLogin")
	public ModelAndView login(String id, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		TeacherVO teacher = teacherService.teacherLogin(id, password);
		System.out.println(teacher);
		if(teacher != null) {
			session.setAttribute("teacher", teacher);
			mav.setViewName("redirect:index");
		}
		else mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping("/teacherLogout")
	public String logout(HttpSession session){
		session.removeAttribute("teacher");
		return "redirect:index";
	}
	@RequestMapping("/teacherJoin")
	public ModelAndView join(TeacherVO teacher) {
		ModelAndView mav = new ModelAndView();
		boolean flag = teacherService.teacherJoin(teacher);
		if(flag) {
			mav.setViewName("redirect:loginForm?login=teacherLogin");
		} else {
			mav.setViewName("teacherJoinForm");
		}
		return mav;
	}
	@RequestMapping("/teacherIdCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam String teacherId) throws IOException {
		boolean flag = teacherService.idCheck(teacherId);
		String result = null;
		PrintWriter out = response.getWriter();
		if(flag) result = "fail";
		else result = "success";
		out.print(result);
		out.close();
	}
	@RequestMapping("/updateTeacherProfile")
	public ModelAndView updateteacherProfile(TeacherVO teacher, HttpSession session, HttpServletRequest request) {
		String path = request.getRealPath("/resources/upload/teacherImg");
		String upPath = path+"\\"+teacher.getUpfile().getOriginalFilename();
		File f = new File(upPath);
		try {
			teacher.getUpfile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		teacher.setImg(teacher.getUpfile().getOriginalFilename());
		ModelAndView mav = new ModelAndView();
		TeacherVO vo = (TeacherVO) session.getAttribute("teacher");
		teacher.setId(vo.getId());
		boolean flag = teacherService.updateTeacherProfile(teacher);
		if(flag) {
			session.setAttribute("teacher", teacher);
			mav.setViewName("teacherPageForm");
		} else {
			mav.setViewName("teacherPageForm");
		}
		return mav;
	}
	@RequestMapping("/teacherPwdCheck")
	public void pwdCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam String teacherPwd) throws IOException {
		HttpSession session = request.getSession();
		TeacherVO teacher = (TeacherVO) session.getAttribute("teacher");
		String teacherId = teacher.getId();
		boolean flag = teacherService.pwdCheck(teacherId, teacherPwd);
		String result = null;
		PrintWriter out = response.getWriter();
		if(flag) result = "success";
		else result = "fail";
		out.print(result);
		out.close();
	}
	
	@RequestMapping("/updateTeacherPwd")
	public ModelAndView updateteacherPwd(@RequestParam String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		TeacherVO teacher = (TeacherVO) session.getAttribute("teacher");
		teacher.setPassword(password);
		ModelAndView mav = new ModelAndView();
		boolean flag = teacherService.updateTeacherPwd(teacher);
		if(flag) {
			// �˾�����!
			mav.setViewName("teacherPageForm");
		} else {
			mav.addObject("msg", "���� ����");
			mav.setViewName("teacherPageForm");
		}
		return mav;
	}
	
}