package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.TeacherVO;

public interface TeacherDAO {
	public int addTeacher(TeacherVO teacher);
	// 관리자 멤버 수정
	public int updateTeacher(TeacherVO teacher);
	// 사용자 프로필 수정
	public int updateTeacherProfile(TeacherVO teacher);
	public int updateTeacherPwd(TeacherVO teacher);
	public int deleteTeacher(String id);
	public TeacherVO getTeacher(String id);
	public List<TeacherVO> getTeacherList();

}
