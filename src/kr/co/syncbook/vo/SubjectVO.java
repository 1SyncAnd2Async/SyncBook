package kr.co.syncbook.vo;

public class SubjectVO {
	private int subj_num, num;
	private String subj_name;
	public int getSubj_num() {
		return subj_num;
	}
	public void setSubj_num(int subj_num) {
		this.subj_num = subj_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubj_name() {
		return subj_name;
	}
	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}
	@Override
	public String toString() {
		return "SubjectVO [subj_num=" + subj_num + ", num=" + num + ", subj_name=" + subj_name + "]";
	}
	
	
}
