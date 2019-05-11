package kr.or.bit.dto;

public class Notice_Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 공지 dto 작성
    */
	
	private int comments_num;
	private String id;
	private int notice_num;
	private String comments_content;
	private String comments_date;
	
	
	public int getComments_num() {
		return comments_num;
	}



	public void setComments_num(int comments_num) {
		this.comments_num = comments_num;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getNotice_num() {
		return notice_num;
	}



	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}



	public String getComments_content() {
		return comments_content;
	}



	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}



	public String getcomments_date() {
		return comments_date;
	}



	public void setcomments_date(String comments_date) {
		this.comments_date = comments_date;
	}



	@Override
	public String toString() {
		return "Notice_Comments [comments_num=" + comments_num + ", id=" + id + ", notice_num=" + notice_num
				+ ", comments_content=" + comments_content + ", comments_date=" + comments_date + "]";
	}
	
	
	
}
