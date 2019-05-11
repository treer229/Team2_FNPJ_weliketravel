package kr.or.bit.dto;


/*
작업일자 : 2019-05-08
작업자 :   이힘찬
작업내용 : 여행후기 dto 작성
*/
public class TravelReview {			//여행후기
	private int tr_num;				//여행후기_글번호
	private String id;				//아이디
	private String tr_title;		//여행후기_제목
	private String content;			//내용
	private int views;				//조회수
	private String created_date;		//작성일
	private int comment_count;		//댓글수
	
	// 계층형
	private int refer; 				// 참조
	private int depth; 				// 들여쓰기
	private int step; 				// 글의 순서
	
	
	public TravelReview() {
		
	}
	
	public TravelReview(int tr_num, String id, String tr_title, String content, int views, String created_date,
			int comment_count, int refer, int depth, int step) {
		this.tr_num = tr_num;
		this.id = id;
		this.tr_title = tr_title;
		this.content = content;
		this.views = views;
		this.created_date = created_date;
		this.comment_count = comment_count;
		this.refer = refer;
		this.depth = depth;
		this.step = step;
	}

	public int getTr_num() {
		return tr_num;
	}

	public void setTr_num(int tr_num) {
		this.tr_num = tr_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTr_title() {
		return tr_title;
	}

	public void setTr_title(String tr_title) {
		this.tr_title = tr_title;
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
	
}
