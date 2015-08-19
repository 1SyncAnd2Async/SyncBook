package kr.co.syncbook.vo;

public class LectureVO {
	private int lecture_num;
	private String isbn;
	private String lecture_file;
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLecture_file() {
		return lecture_file;
	}
	public void setLecture_file(String lecture_file) {
		this.lecture_file = lecture_file;
	}
	@Override
	public String toString() {
		return "LectureVO [lecture_num=" + lecture_num + ", isbn=" + isbn + ", lecture_file=" + lecture_file + "]";
	}
	
	

}
