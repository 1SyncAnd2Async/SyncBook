package kr.co.syncbook.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BookVO {
	private MultipartFile upfile;
	private String isbn, book_name, author, publisher, explanation, img;
	private int subject_num, price;
	private Date publish_date;
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getSubject_num() {
		return subject_num;
	}
	public void setSubject_num(int subject_num) {
		this.subject_num = subject_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "BookVO [upfile=" + upfile + ", isbn=" + isbn + ", book_name=" + book_name + ", author=" + author
				+ ", publisher=" + publisher + ", explanation=" + explanation + ", img=" + img + ", subject_num="
				+ subject_num + ", price=" + price + ", publish_date=" + publish_date + "]";
	}
}
