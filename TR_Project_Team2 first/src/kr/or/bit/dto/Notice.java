package kr.or.bit.dto;

public class Notice {
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : 공지 dto 작성
    */
	private int notice_num;
	private String notice_title;
	private String notice_content;
	private String notice_date;
	private int comment_count;
	private String id;
	private int notice_view;
	
	
	
	public Notice(int notice_num, String notice_title, String notice_content, String notice_date, int comment_count,
			String id, int notice_view) {
		this.notice_num = notice_num;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.comment_count = comment_count;
		this.id = id;
		this.notice_view = notice_view;
	}
	public int getnotice_view() {
		return notice_view;
	}
	public void setnotice_view(int notice_view) {
		this.notice_view = notice_view;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getnotice_num() {
		return notice_num;
	}
	public void setnotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getnotice_title() {
		return notice_title;
	}
	public void setnotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getnotice_content() {
		return notice_content;
	}
	public void setnotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getnotice_date() {
		return notice_date;
	}
	public void setnotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public int getcomment_count() {
		return comment_count;
	}
	public void setcomment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	@Override
	public String toString() {
		return "Notice [notice_num=" + notice_num + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_date=" + notice_date + ", comment_count=" + comment_count + "]";
	}
	
}
