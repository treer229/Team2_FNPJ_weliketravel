package kr.or.bit.dto;

public class Qna_Comments {
	
	/*
    작업일자 : 2019-05-08
    작업자 :    권순조
    작업내용 : QNA댓글 DTO  작성
    */
	
	private int comments_num;
	private String id;
	private int qna_num;
	private String comments_content;
	private String comments_date;
	
	public Qna_Comments(int comments_num, String id, int qna_num, String comments_content, String comments_date) {
		this.comments_num=comments_num;
		this.id=id;
		this.qna_num=qna_num;
		this.comments_content=comments_content;
		this.comments_date=comments_date;
	}
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
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getComments_date() {
		return comments_date;
	}
	public void setComments_date(String comments_date) {
		this.comments_date = comments_date;
	}
	@Override
	public String toString() {
		return "Qna_Comments [comments_num=" + comments_num + ", id=" + id + ", qna_num=" + qna_num
				+ ", comments_content=" + comments_content + ", comments_date=" + comments_date + "]";
	}
	
	
	
}
