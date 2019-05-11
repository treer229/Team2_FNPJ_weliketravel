package kr.or.bit.dto;
/*
작업일자 : 2019-05-08
작업자 :    권순조
작업내용 : 여행리뷰 댓글 dto 작성
*/
public class TravelReview_Comments {
	private int comments_num;
	private String id;
	private int tr_num;
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



	public int getTr_num() {
		return tr_num;
	}



	public void setTr_num(int tr_num) {
		this.tr_num = tr_num;
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
		return "tr_Comments [comments_num=" + comments_num + ", id=" + id + ", tr_num=" + tr_num + ", comments_content="
				+ comments_content + ", comments_date=" + comments_date + "]";
	}

	
	
}
