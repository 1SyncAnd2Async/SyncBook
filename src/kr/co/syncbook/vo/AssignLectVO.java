package kr.co.syncbook.vo;

public class AssignLectVO {
	private int lect_num, status;
	private String teacher_id, day, begintime, endtime;
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
		return "AssignLectureVO [lect_num=" + lect_num + ", status=" + status + ", teacher_id=" + teacher_id + ", day="
				+ day + ", begintime=" + begintime + ", endtime=" + endtime + "]";
	}
}
