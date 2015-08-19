package kr.co.syncbook.vo;

import java.sql.Date;

public class BookVO {
	private String isbn;
	private int subject_num;
	private String book_name;
	private int price;
	private String author;
	private String publisher;
	private Date publish_date;
	
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
	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", subject_num=" + subject_num + ", book_name=" + book_name + ", price=" + price
				+ ", author=" + author + ", publisher=" + publisher + ", publish_date=" + publish_date + "]";
	}
	
	

}
