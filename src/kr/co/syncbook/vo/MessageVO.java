package kr.co.syncbook.vo;

import java.util.Date;

public class MessageVO {
	private String sender, receiver, content, lect_name, beginTime, endTime;
	private int assign_num, lect_num, message_num, status;
	private Date write_date;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLect_name() {
		return lect_name;
	}
	public void setLect_name(String lect_name) {
		this.lect_name = lect_name;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(int assign_num) {
		this.assign_num = assign_num;
	}
	public int getLect_num() {
		return lect_num;
	}
	public void setLect_num(int lect_num) {
		this.lect_num = lect_num;
	}
	public int getMessage_num() {
		return message_num;
	}
	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	@Override
	public String toString() {
		return "MessageVO [sender=" + sender + ", receiver=" + receiver + ", content=" + content + ", lect_name="
				+ lect_name + ", beginTime=" + beginTime + ", endTime=" + endTime + ", assign_num=" + assign_num
				+ ", lect_num=" + lect_num + ", message_num=" + message_num + ", status=" + status + ", write_date="
				+ write_date + "]";
	}
	

}
