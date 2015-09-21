package kr.co.syncbook.vo;

public class AssignLectVO {
	private int assign_num, rnum, lect_num, status;
	private String lect_name, name, teacher_id, day, begintime, endtime;
	public int getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getLect_num() {
		return lect_num;
	}
	public void setLect_num(int lect_num) {
		this.lect_num = lect_num;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLect_name() {
		return lect_name;
	}
	public void setLect_name(String lect_name) {
		this.lect_name = lect_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "AssignLectVO [assign_num=" + assign_num + ", rnum=" + rnum + ", lect_num=" + lect_num + ", status="
				+ status + ", lect_name=" + lect_name + ", name=" + name + ", teacher_id=" + teacher_id + ", day=" + day
				+ ", begintime=" + begintime + ", endtime=" + endtime + "]";
	}
}
