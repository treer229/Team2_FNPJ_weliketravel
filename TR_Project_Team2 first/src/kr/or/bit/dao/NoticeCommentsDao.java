package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.Notice_Comments;

public class NoticeCommentsDao {
	/*
	작업일자 : 2019-05-08
	작업자 :    권순조
	작업내용 : notice DTO 작성
	*/
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public NoticeCommentsDao() {
		try {
			Context context = new InitialContext(); // 이름기반 검색
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			System.out.println("NoticeComments" + e.getMessage());
		}
	}

	public int insertComment(Notice_Comments Notice_comments) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into NOTICE_COMMENTS (NOTICE_COMMENTS_SEQ.NEXTVAL, NOTICE_NUM, ID, CONTENT,CREATED_DATE) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_comments.getNotice_num());
			pstmt.setString(2, Notice_comments.getId());
			pstmt.setString(3, Notice_comments.getComments_content());
			pstmt.setString(4, Notice_comments.getcomments_date());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertComment Exception" + e.getMessage());
			row = -1;
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {} // 반환
		}
		return row;
	}

	public int deleteComment(String id, int comment_num) {
		int row = 0;
		try{
			//String sql = "delete from reply where no=? and pwd =?"
			//String replyselect ="select pwd from reply where no=?";
			//가지고 온 pwd 값 parameter 받은 pwd 일치하면 삭제 처리
			String sql = "delete from NOTICE_COMMENTS where COMMENT_NUM=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_num);
			rs =pstmt.executeQuery();
			if(rs.next()){
					//실제 삭제 처리
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, comment_num);
					row = pstmt.executeUpdate();
			}else{
				row = -1;
				System.out.println("존재하는 댓글이 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}

	public boolean updateComment(int comment_num, String content) {
		boolean check = false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			String sql = "UPDATE NOTICE_COMMENTS SET CONTENT=? WHERE COMMENT_NUM=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, comment_num);
			pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
				check = false;
			} finally{
				if (rs != null) try {rs.close();} catch (Exception e) {}
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
			}
		return check;
}

	public List<Notice_Comments> noticeCommentList(int Notice_Num) {
		List<Notice_Comments> noticommentlist = new ArrayList<Notice_Comments>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			String sql = "select ID, CONTENT, CREATED_DATE from NOTICE_COMMENTS where=? order by no desc";

			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Notice_Num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String content = rs.getString("CONTENT");
				String create_date = rs.getString("CREATED_DATE");

				Notice_Comments noticomments = new Notice_Comments();
				noticomments.setId(id);
				noticomments.setComments_content(content);
				noticomments.setcomments_date(create_date);

				noticommentlist.add(noticomments);
			}

		} catch (Exception e) {
			System.out.println("noticeCommentList :" + e.getMessage());
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return noticommentlist;
	}
}
