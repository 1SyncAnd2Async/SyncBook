package kr.co.syncbook.vo;

import java.util.Date;

public class QnaVO {
	private int qua_num;
	private String title;
	private String content;
	private String writer;
	private Date write_date;
	private int hit;
	private String qna_file;
	public int getQua_num() {
		return qua_num;
	}
	public void setQua_num(int qua_num) {
		this.qua_num = qua_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getQna_file() {
		return qna_file;
	}
	public void setQna_file(String qna_file) {
		this.qna_file = qna_file;
	}
	@Override
	public String toString() {
		return "QnaVO [qua_num=" + qua_num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", hit=" + hit + ", qna_file=" + qna_file + "]";
	}
	
	
	
	
	

}
