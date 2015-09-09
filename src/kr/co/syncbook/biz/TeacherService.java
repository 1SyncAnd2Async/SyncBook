package kr.co.syncbook.biz;

import java.util.List;

import kr.co.syncbook.vo.TeacherVO;

public interface TeacherService {
	public boolean teacherJoin(TeacherVO teacher);
	// ID 중복 체크
	public boolean idCheck(String id);
	public TeacherVO teacherLogin(String id, String pwd);
	public TeacherVO getTeacher(String id);
	// 사용자 프로필 수정
	public boolean updateTeacherProfile(TeacherVO teacher);
	public boolean updateTeacherPwd(TeacherVO teacher);
	public boolean pwdCheck(String id, String pwd);
	public List<TeacherVO> getTeacherList();
}
