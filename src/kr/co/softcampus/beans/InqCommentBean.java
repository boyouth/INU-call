package kr.co.softcampus.beans;

public class InqCommentBean {
	private int inquire_idx;
	private String inquire_comment;
	private String comment_writer;
	private String comment_date;
	
	public int getInquire_idx() {
		return inquire_idx;
	}
	public void setInquire_idx(int inquire_idx) {
		this.inquire_idx = inquire_idx;
	}
	public String getInquire_comment() {
		return inquire_comment;
	}
	public void setInquire_comment(String inquire_comment) {
		this.inquire_comment = inquire_comment;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
}
