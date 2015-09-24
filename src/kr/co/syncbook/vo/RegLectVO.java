package kr.co.syncbook.vo;

public class RegLectVO {
	private int assign_num;
	private String stud_id, phone, email, post, address, detail_address;
	public int getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}
	public String getStud_id() {
		return stud_id;
	}
	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
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
		return "RegLectVO [assign_num=" + assign_num + ", stud_id=" + stud_id + ", phone=" + phone + ", email=" + email
				+ ", post=" + post + ", address=" + address + ", detail_address=" + detail_address + "]";
	}
}
