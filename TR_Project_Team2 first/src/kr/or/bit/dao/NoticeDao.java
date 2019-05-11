package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice;

public class NoticeDao {
	
	/*
	작업일자 : 2019-05-09
	작업자 :    권순조
	작업내용 : notice board 작성
	*/
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public NoticeDao() {//DB연결
		try {
			Context context = new InitialContext(); // 이름기반 검색
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("NoticeComments" + e.getMessage());
		}
	}
	
	public int noticeWrite(Notice notice) {//일반 게시판 글쓰기 작업
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into NOTICE(NOTICE_NUM,TITLE,CONTENT,VIEWS,CREATED_DATE,COMMENT_COUNT,id) values("
					+ " NOTICE_SEQ.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, notice.getnotice_title());
			pstmt.setString(2, notice.getnotice_content());
			pstmt.setInt(3, notice.getnotice_view());
			pstmt.setString(4, notice.getnotice_date());
			pstmt.setInt(5, notice.getcomment_count());
			pstmt.setString(6, notice.getId());

			row = pstmt.executeUpdate();
		} 
		 catch (Exception e) {
		   e.printStackTrace(); 
		   } finally {
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}

	public Notice getContent(int notice_num) {//공지글 상세보기 출력
		Notice notice = null;
		try{
				conn = ds.getConnection();
				String sql ="select * from NOTICE where notice_num=?";
			  	pstmt = conn.prepareStatement(sql);
			  	pstmt.setInt(1, notice_num);
			  			  	
				rs =pstmt.executeQuery();
			    
				if(rs.next()){
					int num = rs.getInt("notice_num");
					String title = rs.getString("notice_title");
					String content = rs.getString("notice_content");
					String date = rs.getString("notice_date");
					String id = rs.getString("id");
					int comment_count = rs.getInt("comment_count");
					int view = rs.getInt("notirce_view");
					
					notice = new Notice(num, title, content, date, comment_count,id, view);
				} else {
					System.out.println("입력실패");
				}
		 	} catch (Exception e) {
				e.getStackTrace();
			}
		    finally{
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
		    }
		 return notice;
	}	
	
	
	public int updateNotice(int notice_num, Notice notice) {//title과 content를 수정한다.
		int row = 0;
		try{
			String sql = "update NOTICE set title=?,content=?  where=noticce_num=?";
			conn = ds.getConnection();
			pstmt.setString(1, notice.getnotice_title());
			pstmt.setString(2, notice.getnotice_content());
			pstmt.setInt(3, notice_num);
			
			row = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.getStackTrace();
			row = -1;
		}finally{
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}
	
	public int deleteNotice(int num) {
		  int row = 0;
	      PreparedStatement pstmt = null;

	      try{
	         conn = ds.getConnection();
	         String sql = "delete from NOTICE where NOTICE_NUM=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         row = pstmt.executeUpdate();

	      }catch(Exception e){
	         System.out.println(e.getMessage());
	      }finally {
		    if(pstmt!=null) try{pstmt.close();}catch (Exception e){}
			if(conn!=null) try{conn.close();}catch (Exception e){} //반환
	      }
		return row;
	}
	
}
