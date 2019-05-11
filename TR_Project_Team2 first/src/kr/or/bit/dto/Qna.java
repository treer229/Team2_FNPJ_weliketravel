/*
     작업일자 : 2019/05/08
     작업자 : 이노진
     작업내용 : 묻고답하기 게시판 dto
*/
package kr.or.bit.dto;

public class Qna {

	private int qna_num;				//묻고답하기_글번호
	private String id;					//아이디
	private String qna_title;			//묻고답하기_제목
	private String content;				//내용
	private int views;					//조회수
	private String created_date;	//작성일
	private int comment_count;		//댓글수
	
	//계층형
	private int refer;	//참조
	private int depth;	//들여쓰기
	private int step;	//글의 순서
	public Qna() {
		
	}
	
	public Qna(int qna_num, String id, String qna_title, String content, int views, String created_date,
			int comment_count, int refer, int depth, int step) {
		// TODO Auto-generated constructor stub
		this.qna_num=qna_num;
		this.id=id;
		this.qna_title=qna_title;
		this.content=content;
		this.views=views;
		this.created_date=created_date;
		this.comment_count=comment_count;
		this.refer=refer;
		this.depth=depth;
		this.step=step;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	@Override
	public String toString() {
		return "Qna [qna_num=" + qna_num + ", id=" + id + ", qna_title=" + qna_title + ", content=" + content
				+ ", views=" + views + ", created_date=" + created_date + ", comment_count=" + comment_count
				+ ", refer=" + refer + ", depth=" + depth + ", step=" + step + "]";
	}
	
	
	
}
