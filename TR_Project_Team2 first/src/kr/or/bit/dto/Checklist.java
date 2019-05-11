package kr.or.bit.dto;

public class Checklist {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트 dto 작성
    */
	
	private int cl_num;
	private String id;
	private String cl_title;
	private String color;
	
	
	public int getCl_num() {
		return cl_num;
	}



	public void setCl_num(int cl_num) {
		this.cl_num = cl_num;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCl_title() {
		return cl_title;
	}



	public void setCl_title(String cl_title) {
		this.cl_title = cl_title;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	@Override
	public String toString() {
		return "Checklist [CL_NUM=" + cl_num + ", id=" + id + ", CL_TITLE=" + cl_title + ", COLOR=" + color + "]";
	}
	
}
