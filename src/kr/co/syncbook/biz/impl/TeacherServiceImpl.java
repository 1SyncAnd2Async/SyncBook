package kr.co.syncbook.biz.impl;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.syncbook.biz.TeacherService;
import kr.co.syncbook.dao.TeacherDAO;
import kr.co.syncbook.vo.TeacherVO;

@Service("TeacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDAO teacherDAO;
	
	@Override
	@Transactional(readOnly=false)
	public boolean teacherJoin(TeacherVO teacher) throws RuntimeException {
		System.out.println(teacher);
		int result = teacherDAO.addTeacher(teacher);
		TeacherVO vo = teacherDAO.getTeacher(teacher.getId());
		if(teacherDAO.getTeacher(teacher.getId()).equals(vo.getId()))
			throw new RuntimeException();
		if(result==1) return true;
		else return false;
	}
	
	// ID 중복 체크
	@Override
	@Transactional(readOnly=false)
	public boolean idCheck(String teacherId) {
		List<TeacherVO> list = teacherDAO.getTeacherList();
		if(list != null){
			for(TeacherVO v : list){
				if(teacherId.equals(v.getId()))
					return true;
			}
		}
		return false;
	}

	@Override
	@Transactional(readOnly=false)
	public TeacherVO teacherLogin(String id, String pwd) {
		TeacherVO teacher = teacherDAO.getTeacher(id);
		if(teacher != null && teacher.getId().equals(id)) {
			if(teacher.getPassword().equals(pwd)){
				return teacher;
			}
			return null;
		} else return null;
	}
	
	@Override
	@Transactional(readOnly=false)
	public TeacherVO getTeacher(String id){
		TeacherVO teacher = teacherDAO.getTeacher(id);
		return teacher;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean updateTeacherProfile(TeacherVO teacher) {
		int result = teacherDAO.updateTeacherProfile(teacher);
		if(result==1) return true;
		else return false;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean updateTeacherPwd(TeacherVO Teacher) {
		int result = teacherDAO.updateTeacherPwd(Teacher);
		if(result==1) return true;
		else return false;
	}

	@Override
	public boolean pwdCheck(String id, String pwd) {
		TeacherVO Teacher = teacherDAO.getTeacher(id);
		if(Teacher != null){
			if(pwd.equals(Teacher.getPassword()))
				return true;
		}
		return false;
	}

	@Override
	public List<TeacherVO> getTeacherList(){
		List<TeacherVO> list = teacherDAO.getTeacherList();
		return list;
	}

}