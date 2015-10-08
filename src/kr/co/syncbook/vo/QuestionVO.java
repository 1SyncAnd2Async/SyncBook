package kr.co.syncbook.vo;

import org.springframework.web.multipart.MultipartFile;

public class QuestionVO {
	private int book_num, unit_num, question_num;
	private String content, explanation, question_file;
	private MultipartFile upImg, upVideo;
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public MultipartFile getUpImg() {
		return upImg;
	}
	public void setUpImg(MultipartFile upImg) {
		this.upImg = upImg;
	}
	public MultipartFile getUpVideo() {
		return upVideo;
	}
	public void setUpVideo(MultipartFile upVideo) {
		this.upVideo = upVideo;
	}
	@Override
	public String toString() {
		return "QuestionVO [book_num=" + book_num + ", unit_num=" + unit_num + ", question_num=" + question_num
				+ ", content=" + content + ", explanation=" + explanation + ", question_file=" + question_file
				+ ", upImg=" + upImg + ", upVideo=" + upVideo + "]";
	}
}
