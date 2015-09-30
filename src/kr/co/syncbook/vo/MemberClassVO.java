package kr.co.syncbook.vo;

public class MemberClassVO {
	private int reg_num;
	private String member_id, lect_name, explanation, beginTime, endTime,
			teacher_id, teacher_name, teacher_phone, teacher_email,
			teacher_img, book_name, subj_name, lect_img;
	
	

	public int getReg_num() {
		return reg_num;
	}

	public void setReg_num(int reg_num) {
		this.reg_num = reg_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getLect_name() {
		return lect_name;
	}

	public void setLect_name(String lect_name) {
		this.lect_name = lect_name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_phone() {
		return teacher_phone;
	}

	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public String getTeacher_img() {
		return teacher_img;
	}

	public void setTeacher_img(String teacher_img) {
		this.teacher_img = teacher_img;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getSubj_name() {
		return subj_name;
	}

	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

	public String getLect_img() {
		return lect_img;
	}

	public void setLect_img(String lect_img) {
		this.lect_img = lect_img;
	}

	@Override
	public String toString() {
		return "MemberClassVO [reg_num=" + reg_num + ", member_id=" + member_id + ", lect_name=" + lect_name
				+ ", explanation=" + explanation + ", beginTime=" + beginTime + ", endTime=" + endTime + ", teacher_id="
				+ teacher_id + ", teacher_name=" + teacher_name + ", teacher_phone=" + teacher_phone
				+ ", teacher_email=" + teacher_email + ", teacher_img=" + teacher_img + ", book_name=" + book_name
				+ ", subj_name=" + subj_name + ", lect_img=" + lect_img + "]";
	}

	

	
	

}
