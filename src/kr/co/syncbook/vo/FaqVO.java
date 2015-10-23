package kr.co.syncbook.vo;

public class FaqVO {
	private int faq_num;
	private String title;
	private String content;
	private String writer;
	private String write_date;
	private int hit;
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
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
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "FaqVO [faq_num=" + faq_num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", hit=" + hit + "]";
	}
	
	
	
	
	

}
