package kr.co.softcampus.beans;

public class FreeCommentBean {
	
	private int free_idx;
	private String free_comment;
	private String comment_writer;
	private String comment_date;
	
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}
	public String getFree_comment() {
		return free_comment;
	}
	public void setFree_comment(String free_comment) {
		this.free_comment = free_comment;
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
