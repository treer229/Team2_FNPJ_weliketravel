package kr.or.bit.dto;

public class Checklistcontent {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트Content dto 작성
    */
	private int clc_num;
	private int cl_num;
	private String content;
	
	public int getClc_num() {
		return clc_num;
	}
	public void setClc_num(int clc_num) {
		this.clc_num = clc_num;
	}
	public int getCl_num() {
		return cl_num;
	}
	public void setCl_num(int cl_num) {
		this.cl_num = cl_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Checklistcontent [clc_num=" + clc_num + ", cl_num=" + cl_num + ", content=" + content + "]";
	}
	
	
	
	
	
}
