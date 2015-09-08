package kr.co.syncbook.vo;

public class LectureVO {
	private int num, lect_num, subj_num, book_num, price;
	private String lect_name, subj_name, teacher_id, day, beginTime, endTime, book_name, teacher_name;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLect_num() {
		return lect_num;
	}
	public void setLect_num(int lect_num) {
		this.lect_num = lect_num;
	}
	public int getSubj_num() {
		return subj_num;
	}
	public void setSubj_num(int subj_num) {
		this.subj_num = subj_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getLect_name() {
		return lect_name;
	}
	public void setLect_name(String lect_name) {
		this.lect_name = lect_name;
	}	
	public String getSubj_name() {
		return subj_name;
	}
	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
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
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "LectureVO [num=" + num + ", lect_num=" + lect_num + ", subj_num=" + subj_num + ", book_num=" + book_num
				+ ", price=" + price + ", lect_name=" + lect_name + ", subj_name=" + subj_name + ", teacher_id="
				+ teacher_id + ", day=" + day + ", beginTime=" + beginTime + ", endTime=" + endTime + ", book_name="
				+ book_name + ", teacher_name=" + teacher_name + "]";
	}
	
	
	
	
	

}
