package kr.co.syncbook.vo;

import org.springframework.web.multipart.MultipartFile;

public class LectureDataVO {
	private int rownum, num, assign_num;
	private String img, title;
	private MultipartFile upfile;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "LectureDataVO [num=" + num + ", assign_num=" + assign_num + ", img=" + img + ", title=" + title
				+ ", upfile=" + upfile + "]";
	}
	
	
	

}
