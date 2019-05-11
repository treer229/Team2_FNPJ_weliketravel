package kr.or.bit.dto;
/*
작업일자 : 2019-05-08
작업자 :   이힘찬
작업내용 : 회원 dto 작성
*/
public class Member { 			//회원table
	private String id;			//아이디
	private String password;	//비밀번호
	private String name;		//이름
	private int gender;			//성별		
	private String email;		//이메일
	private String travel;		//관심여행지역
	private int admin;			//관리여부
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", email="
				+ email + ", travel=" + travel + ", admin=" + admin + "]";
	}
	
	
	
	
	
}
