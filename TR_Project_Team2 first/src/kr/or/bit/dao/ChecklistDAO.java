package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Checklist;
import kr.or.bit.dto.Checklistcontent;
import kr.or.bit.dto.Checklistok;

/*
작업일자 : 2019-05-08
작업자 :    정진호
작업내용 : 체크리스트 DTO 작성
*/
public class ChecklistDAO {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ChecklistDAO() {
		try {
			  Context context = new InitialContext(); //이름기반 검색
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("look yp Fail"+ e.getMessage());
		}
	}
	
	public List<Checklist> getCheckListAll(String id) {
		List<Checklist> checklist = new ArrayList<Checklist>();
		
		try {
			conn = ds.getConnection();
			String sql = "select * from CHECKLIST where id = ? ORDER BY CL_NUM DESC ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println("체크리스트 검색 쿼리문 실행 완료");
			
			while(rs.next()) {
				Checklist check = new Checklist();
				check.setCl_num(rs.getInt(1));
				check.setId(rs.getString(2));
				check.setCl_title(rs.getString(3));
				check.setColor(rs.getString(4));
				checklist.add(check);
			}
		} catch (Exception e) {
			System.out.println("체크리스트 출력 에러 : " + e.getMessage());
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("CHACKLIST rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("CHACKLIST pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("CHACKLIST conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return checklist;
	}
	public Checklist getCheckList(int cl_num) { //단일검색
		Checklist check = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from CHECKLIST where CL_NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cl_num);
			rs = pstmt.executeQuery();
			System.out.println("체크리스트 단일검색 쿼리문 실행 완료");
			
			if(rs.next()) {
			check = new Checklist();
				check.setCl_num(rs.getInt(1));
				check.setId(rs.getString(2));
				check.setCl_title(rs.getString(3));
				check.setColor(rs.getString(4));
			}else {
				System.out.println("정보 담기 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트 출력 에러 : " + e.getMessage());
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("CHACKLIST rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("CHACKLIST pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("CHACKLIST conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return check;
	}
	public List<Checklistcontent> getChecklistContent(int clc_num) {
		List<Checklistcontent> list = new ArrayList<Checklistcontent>();
		
		try {
			conn = ds.getConnection();
			String sql = "select * from CHECKLIST_CONTENT where CL_NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clc_num);
			
			rs = pstmt.executeQuery();
			System.out.println("체크컨텐츠 쿼리문 실행 완료");
			if(rs.next()) {
				
				do {
					Checklistcontent content = new Checklistcontent();
					content = new Checklistcontent();
					content.setClc_num(rs.getInt(1));
					content.setCl_num(rs.getInt(2));
					content.setContent(rs.getString(3));
					
					list.add(content);
				}while(rs.next());
				System.out.println("체크컨텐츠 담기 완료");
			}else {
				System.out.println("체크컨텐츠 없음");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트 컨텐츠 받아오기 실패");
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("체크컨텐츠 rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크컨텐츠 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크컨텐츠 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return list;
	}
	public List<Checklistok> getCheckListok(Checklistcontent content) {
		List<Checklistok> list = new ArrayList<Checklistok>();
		try {
			conn = ds.getConnection();
			String sql = "select * from CHECKLIST_CHECKED where CLC_NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, content.getClc_num());
			
			rs = pstmt.executeQuery();
			System.out.println("체크리스트 확인 불러오기 성공");
			while(rs.next()) {
				Checklistok listok = new Checklistok();
				listok.setClc_num(rs.getInt(1));
				listok.setClcc_checked(rs.getInt(2));
				list.add(listok);
			}
			System.out.println("체크리스트 확인정보 담기 완료");
		} catch (Exception e) {
			System.out.println("체크리스트 확인 불러오기 오류");
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {System.out.println("체크리스트확인 rs DB서버 닫기 실패"); System.out.println(e.getMessage());}
    	  	if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트확인 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트확인 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
	
		return list;
	}
	public int getDeleteChackList(int cl_num) {
		int row = 0;
		
		int listdelete2 = getDeleteChecklistContentAll(cl_num);
		System.out.println("컨텐츠삭제 row : " + listdelete2);
		
		try {
			conn = ds.getConnection();
			String sql = "delete from CHECKLIST where CL_NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cl_num);
			System.out.println("체크리스트 삭제 성공");
			
			row = pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("전체 삭제 성공");
			}else {
				System.out.println("전체 삭제 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트 전체삭제 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트삭제 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트삭제 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return row;
	}
	
	public int getDeleteChecklistContentAll(int cl_num) {
		int row = 0;
		int row2 = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "delete from CHECKLIST_CONTENT where CL_NUM = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, cl_num);
			row2 = pstmt.executeUpdate();
			 
			if(row2 > 0) {
				System.out.println("체크리스트컨텐츠 전체 삭제 성공");
			}else {
				System.out.println("체크리스트컨텐츠 전체 삭제 실패");
			}
		} catch (Exception e) {
			System.out.println("체크리스트컨텐츠 삭제 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트컨텐츠전체삭제 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트컨텐츠전체삭제 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return row;
	}
	
	public int getDeleteChecklistContent(int clc_num) {
		int row = 0;
		int row2 = 0;
		
		try {
			conn = ds.getConnection();
			
			String sql = "delete from CHECKLIST_CONTENT where CLC_NUM = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, clc_num);
			row2 = pstmt.executeUpdate();
			 
			if(row2 > 0) {
				System.out.println("체크리스트컨텐츠  삭제 성공");
			}else {
				System.out.println("체크리스트컨텐츠  삭제 실패");
			}
		} catch (Exception e) {
			System.out.println("체크리스트컨텐츠 삭제 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트컨텐츠삭제 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트컨텐츠삭제 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return row;
	}
	
	 

	public int getUpdateChecklist(Checklist checklist) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "update CHECKLIST set CL_TITLE=?, COLOR=? where CL_NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checklist.getCl_title());
			pstmt.setString(2, checklist.getColor());
			pstmt.setInt(3, checklist.getCl_num());
			row = pstmt.executeUpdate();
			System.out.println("업데이트 준비완료");
			if(row > 0 ) { 
				System.out.println("체크리스트 업데이트 성공");
			}else {
				System.out.println("체크리스트 업데이트 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트 업데이트 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트업데이트 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트업데이트 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		
		return row;
	}
	public int getUpdateChecklistContent(Checklist checklist , String content) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "update CHECKLIST_CONTENT set CONTENT=? where CL_NUM = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, content);
			pstmt.setInt(2, checklist.getCl_num());
			row = pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println("체크리스트 컨텐츠 수정 완료");
			}else {
				System.out.println("체크리스트 컨텐츠 수정 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트컨텐츠 업데이트 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트컨텐츠업데이트 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트컨텐츠업데이트 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return row;
	}
	
	public int getInsertChecklistContent(Checklistcontent content) {
		int num =0;
		int row = 0;
		String sql ="";
		
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement("select max(CLC_NUM) from CHECKLIST_CONTENT");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num =rs.getInt(1)+1;
			}else {
				num=1;
			}
			
			sql = "insert into CHECKLIST_CONTENT(CLC_NUM,CL_NUM,CONTENT) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2,content.getCl_num());
			pstmt.setString(3, content.getContent());
			row = pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println("체크리스트 컨텐츠 추가 완료");
			}else {
				System.out.println("체크리스트 컨텐츠 추가 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트컨텐츠 추가 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스트컨텐츠추가 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트컨텐츠추가 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		return row;
	}
	public int getInsertChecklist(Checklist checklist) {
		int num =0;
		int row = 0;
		String sql ="";
		
		
		try{
			conn = ds.getConnection();
			pstmt= conn.prepareStatement("select max(CL_NUM) from CHECKLIST");
			rs = pstmt.executeQuery();
		
			
			if(rs.next()) {
				num =rs.getInt(1)+1;
			}else {
				num=1;
			}
			sql = "insert into checklist(cl_num,id,cl_title,color) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, num);
			System.out.println("num값 " +num);
			pstmt.setString(2, checklist.getId());
			System.out.println("checklist.getId()" + checklist.getId());
			pstmt.setString(3, checklist.getCl_title());
			System.out.println("checklist.getCl_title()" + checklist.getCl_title());
			pstmt.setString(4, checklist.getColor());
			
			row = pstmt.executeUpdate();
			
			if(row > 0 ) { 
				System.out.println("체크리스트 추가 성공");
			}else {
				System.out.println("체크리스트 추가 실패");
			}
			
		} catch (Exception e) {
			System.out.println("체크리스트추가 에러");
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch (Exception e){System.out.println("체크리스추가 pstmt DB서버 닫기 실패"); System.out.println(e.getMessage());}
			if(conn!=null) try{conn.close();}catch (Exception e){System.out.println("체크리스트추가 conn DB서버 닫기 실패"); System.out.println(e.getMessage());}
	}
		
		return row;
	}
	
	
	
}
