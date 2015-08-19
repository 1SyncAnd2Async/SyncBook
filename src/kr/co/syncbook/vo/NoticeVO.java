package kr.co.syncbook.vo;

import java.util.Date;

public class NoticeVO {
	private int notice_num;
	private String title;
	private String content;
	private String writer;
	private Date write_date;
	private int hit;
	private String notice_file;
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
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
	public String getNotice_file() {
		return notice_file;
	}
	public void setNotice_file(String notice_file) {
		this.notice_file = notice_file;
	}
	@Override
	public String toString() {
		return "NoticeVO [notice_num=" + notice_num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", hit=" + hit + ", notice_file=" + notice_file + "]";
	}

}
