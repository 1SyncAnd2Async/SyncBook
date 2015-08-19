package kr.co.syncbook.vo;

public class QuestionVO {
	private String isbn;
	private int unit_num;
	private int question_num;
	private String explanation;
	private String question_file;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getUnit_num() {
		return unit_num;
	}
	public void setUnit_num(int unit_num) {
		this.unit_num = unit_num;
	}
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getQuestion_file() {
		return question_file;
	}
	public void setQuestion_file(String question_file) {
		this.question_file = question_file;
	}
	@Override
	public String toString() {
		return "QuestionVO [isbn=" + isbn + ", unit_num=" + unit_num + ", question_num=" + question_num
				+ ", explanation=" + explanation + ", question_file=" + question_file + "]";
	}
	
	

}
