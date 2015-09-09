package kr.co.syncbook.dao;

import java.util.List;

import kr.co.syncbook.vo.TeacherVO;

public interface TeacherDAO {
	public int addTeacher(TeacherVO teacher);
	// ������ ��� ����
	public int updateTeacher(TeacherVO teacher);
	// ����� ������ ����
	public int updateTeacherProfile(TeacherVO teacher);
	public int updateTeacherPwd(TeacherVO teacher);
	public int deleteTeacher(String id);
	public TeacherVO getTeacher(String id);
	public List<TeacherVO> getTeacherList();

}
