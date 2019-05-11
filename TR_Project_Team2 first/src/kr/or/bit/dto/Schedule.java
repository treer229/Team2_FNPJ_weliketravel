package kr.or.bit.dto;

public class Schedule {
	/*
    작업일자 : 2019-05-08
    작업자 :    정진호
    작업내용 : 스케줄 dto 작성
    */
	
	private int schedule_num;
	private int deleteok;
	private int completeok;
	private String id;
	private String schedule_title;
	private String content;
	private String color;
	private String schedule_start;
	private String schedule_end;
	
	public int getSchedule_num() {
		return schedule_num;
	}
	public void setSchedule_num(int schedule_num) {
		this.schedule_num = schedule_num;
	}
	public int getDeleteok() {
		return deleteok;
	}
	public void setDeleteok(int deleteok) {
		this.deleteok = deleteok;
	}
	public int getCompleteok() {
		return completeok;
	}
	public void setCompleteok(int completeok) {
		this.completeok = completeok;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchedule_title() {
		return schedule_title;
	}
	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSchedule_start() {
		return schedule_start;
	}
	public void setSchedule_start(String schedule_start) {
		this.schedule_start = schedule_start;
	}
	public String getSchedule_end() {
		return schedule_end;
	}
	public void setSchedule_end(String schedule_end) {
		this.schedule_end = schedule_end;
	}
	@Override
	public String toString() {
		return "Schedule [schedule_num=" + schedule_num + ", deleteok=" + deleteok + ", completeok=" + completeok
				+ ", id=" + id + ", schedule_title=" + schedule_title + ", content=" + content + ", color=" + color
				+ ", schedule_start=" + schedule_start + ", schedule_end=" + schedule_end + "]";
	}
	
	
	
	
}
