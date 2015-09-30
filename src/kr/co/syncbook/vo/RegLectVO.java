package kr.co.syncbook.vo;

public class RegLectVO {
	private int assign_num;
	private String beginTime, endTime, member_id, phone, email, post, address, detail_address;
	
	
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
	public int getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	@Override
	public String toString() {
		return "RegLectVO [assign_num=" + assign_num + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", member_id=" + member_id + ", phone=" + phone + ", email=" + email + ", post=" + post + ", address="
				+ address + ", detail_address=" + detail_address + "]";
	}
	
}
