package kr.or.bit.dto;

public class Checklistok {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 체크리스트OK dto 작성
    */
	
	private int clc_num;
	private int clcc_checked;
	
	public int getClc_num() {
		return clc_num;
	}
	public void setClc_num(int clc_num) {
		this.clc_num = clc_num;
	}
	public int getClcc_checked() {
		return clcc_checked;
	}
	public void setClcc_checked(int clcc_checked) {
		this.clcc_checked = clcc_checked;
	}
	@Override
	public String toString() {
		return "Checklistok [clc_num=" + clc_num + ", clcc_checked=" + clcc_checked + "]";
	}
	
	
	
}
