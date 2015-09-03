package kr.co.syncbook.vo;

public class BookVO {
	private String book_name;
	private int book_num, subj_num;
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getSubj_num() {
		return subj_num;
	}
	public void setSubj_num(int subj_num) {
		this.subj_num = subj_num;
	}
	@Override
	public String toString() {
		return "BookVO [book_name=" + book_name + ", book_num=" + book_num + ", subj_num=" + subj_num + "]";
	}
	
	
}
