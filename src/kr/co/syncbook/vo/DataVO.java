package kr.co.syncbook.vo;

import org.springframework.web.multipart.MultipartFile;

public class DataVO {
	private int num, data_num, lect_num;
	private String title, data_file;
	private MultipartFile upfile;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getData_num() {
		return data_num;
	}
	public void setData_num(int data_num) {
		this.data_num = data_num;
	}
	public int getLect_num() {
		return lect_num;
	}
	public void setLect_num(int lect_num) {
		this.lect_num = lect_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData_file() {
		return data_file;
	}
	public void setData_file(String data_file) {
		this.data_file = data_file;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "DataVO [num=" + num + ", data_num=" + data_num + ", lect_num=" + lect_num + ", title=" + title
				+ ", data_file=" + data_file + ", upfile=" + upfile + "]";
	}
	
	
}
