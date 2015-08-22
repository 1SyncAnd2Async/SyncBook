package kr.co.syncbook.vo;

public class SubjectVO {
	private int subject_num;
	private String category, subject_name;
	public int getSubject_num() {
		return subject_num;
	}
	public void setSubject_num(int subject_num) {
		this.subject_num = subject_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	@Override
	public String toString() {
		return "SubjectVO [subject_num=" + subject_num + ", category=" + category + ", subject_name=" + subject_name
				+ "]";
	}
}
