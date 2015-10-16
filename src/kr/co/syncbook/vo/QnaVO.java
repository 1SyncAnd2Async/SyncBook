package kr.co.syncbook.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class QnaVO {
	private int qna_num;
	private String title;
	private String content;
	private String writer;
	private Date write_date;
	private int hit;
	private String qna_file;
	private MultipartFile upfile;
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
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
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "QnaVO [qna_num=" + qna_num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", hit=" + hit + ", qna_file=" + qna_file + ", upfile=" + upfile + "]";
	}
	
	
	
	
	
	

}
