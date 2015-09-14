package kr.co.syncbook.vo;

import org.springframework.web.multipart.MultipartFile;

public class LectureVO {
	private int rnum, lect_num, subj_num, book_num, price;
	private String lect_name, subj_name, book_name, img;
	private MultipartFile upfile;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "LectureVO [rnum=" + rnum + ", lect_num=" + lect_num + ", subj_num=" + subj_num + ", book_num="
				+ book_num + ", price=" + price + ", lect_name=" + lect_name + ", subj_name=" + subj_name
				+ ", book_name=" + book_name + ", img=" + img + ", upfile=" + upfile + "]";
	}
}
