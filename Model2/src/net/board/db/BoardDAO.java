package net.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	private Connection getConnection() throws Exception{
//		String dbUrl = "jdbc:mysql://localhost:3306/jspdb2";
//		String dbId = "jspid";
//		String dbPass = "jsppass";
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(dbUrl,dbId,dbPass);
//		return con;
		
		
		
		//커넥션 풀(connection pool)
		//데이터베이스와 연결된 connection 객체를 미리 생성하여
		//pool 속에 저장해 두고 필요할때마다 이풀을 접근하여 connection 객체 사용
		//작업이 끝나면 다시 반환
		
		
		//자카르타 DBCP API 이용한 커넥션 풀
		//	1. WebContent - META - INF - context.xml 만들기
		//		1단계, 2단계 기술 -> 디비연동 이름 정의
		//	2. WebContent - WEB_INF - web.xml 수정
		//		context.xml 에 db연동해놓은 이름을 모든 페이지에 알려줌
		//	3. DB작업(DAO) - 이름을 불러서 사용
		
		
		Connection con = null;
		//Context 객체 생성
		Context init = new InitialContext();
		//DateSource = 디비연동 이름 불러오기
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysqlDB");
		//con = DataSource
		con = ds.getConnection();
		return con;
		
	}

	public void insertBoard(BoardBean bb){
		ResultSet rs = null;
		int num = 0;
		try{
			
			//1,2디비연결 메서드호출
			con = getConnection();
			//num 게시판 글번호 구하기
			//sql 함수 최대값 구하기 max()
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1)+1;
			//3. sql insert  디비날짜 now()
			sql = "insert into board(num,name,pass,subject,content,"
					+ "readcount,re_ref,re_lev,re_seq,date,ip,file) "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); //일반글의 글번호
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, 0); //readcount 조회수 초기값 = 0
			pstmt.setInt(7, num); //re_ref 답변글 그룹 == 일반글의 글번호
			pstmt.setInt(8, 0); //re_lev 답변글 들여쓰기, 일반글 들여쓰기 없음값 0
			pstmt.setInt(9, 0);//re_seq 답변글 순서, 일반글 순서 맨위값 0
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			//4. 실행
			pstmt.executeUpdate();
			 
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		
	}// insertBoard() end
	
	public int getBoardCount(){
		ResultSet rs = null;
		int count = 0;
		try{			
			//1,2디비연결 메서드호출
			con = getConnection();
			//num 게시판 글번호 구하기
			//sql 함수 최대값 구하기 max()
			sql = "select count(num) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
			//3. sql insert  디비날짜 now()			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		return count;
	}// getBoardCount() end
	
	public List<BoardBean> getBoardList(int startRow, int pageSize){
		ResultSet rs = null;
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		try{
			
			//1,2디비연결 메서드호출
			con = getConnection();
			//num 게시판 글번호 구하기
			//sql 함수 최대값 구하기 max()
			sql = "select * from board order by re_ref desc, re_seq asc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardBean bb = new BoardBean();
				bb.setNum(rs.getInt(1));
				bb.setName(rs.getString(2));
				bb.setPass(rs.getString(3));
				bb.setSubject(rs.getString(4));
				bb.setContent(rs.getString(5));
				bb.setReadcount(rs.getInt(6));
				bb.setRe_ref(rs.getInt(7));
				bb.setRe_lev(rs.getInt(8));
				bb.setRe_seq(rs.getInt(9));
				bb.setDate(rs.getDate(10));
				bb.setIp(rs.getString(11));
				bb.setFile(rs.getString(12));
				boardList.add(bb);
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		return boardList;
	} //getBoardList() end 
	
	public BoardBean getBoard(int num){
		ResultSet rs = null;
		BoardBean bb = new BoardBean();
		try{			
			//1,2디비연결 메서드호출
			con = getConnection();
			//num 게시판 글번호 구하기
			//sql 함수 최대값 구하기 max()
			sql = "select * from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()){				
				bb.setNum(rs.getInt(1));
				bb.setName(rs.getString(2));
				bb.setPass(rs.getString(3));
				bb.setSubject(rs.getString(4));
				bb.setContent(rs.getString(5));
				bb.setReadcount(rs.getInt(6));
				bb.setRe_ref(rs.getInt(7));
				bb.setRe_lev(rs.getInt(8));
				bb.setRe_seq(rs.getInt(9));
				bb.setDate(rs.getDate(10));
				bb.setIp(rs.getString(11));
				bb.setFile(rs.getString(12));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		return bb;		
	}// getBoard() end
	
	public void updateReadcount(int num){
		ResultSet rs = null;
		try{			
			con = getConnection();
			sql = "update board set readcount=readcount+1 where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
	}// updateReadcount() end
	
	public int updateBoard(BoardBean bb){
		int check = -1;
		ResultSet rs = null;
		try{			
			con = getConnection();
			sql = "select pass from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bb.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(bb.getPass().equals(rs.getString("pass"))){
					sql = "update board set name=?, subject=?, content=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bb.getName());
					pstmt.setString(2, bb.getSubject());
					pstmt.setString(3, bb.getContent());
					pstmt.setInt(4, bb.getNum());
					pstmt.executeUpdate();
					check = 1;
				} else {
					check = 0;
				}
			}			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		return check;
	}// updateBoard() end
	
	public int deleteBoard(int num, String pass) {
		int check = -1;
		ResultSet rs = null;
		try{
			con = getConnection();
			sql = "select pass from board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if (pass.equals(rs.getString("pass"))) {
					sql = "delete from board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					check = 1;
				} else {
					check = 0;
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		return check;
	} //deleteBoard() end
	
	public void reInsertBoard(BoardBean bb){
		ResultSet rs = null;
		int num = 0;
		try{
			
			// 1,2디비연결 메서드호출
			con = getConnection();
			// 3sql select 최대 num구하기
			sql = "select max(num) from board";
			pstmt = con.prepareStatement(sql);
			// 4 rs = 실행저장
			rs = pstmt.executeQuery();
			// 5 rs데이터 있으면 num=1번째열을 가져와서+1
			if(rs.next()) num = rs.getInt(1)+1;
			
			
			
			// 답글순서 재배치
			// 3. update 조건 re_ref 같은그룹 re_seq 기존값보다 큰값이 있으면
			// re_seq 1증가
			sql = "update board set re_seq = re_seq+1 where re_ref=? and re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bb.getRe_ref());
			pstmt.setInt(2, bb.getRe_seq());
			// 4. 실행
			pstmt.executeUpdate();
			
			
			
			// 3 sql insert num 구한값	re_ref 그대로
			//					re_lev+1		re_seq+1
			sql = "insert into board(num,name,pass,subject,content,"
					+ "readcount,re_ref,re_lev,re_seq,date,ip,file) "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); //일반글의 글번호
			pstmt.setString(2, bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, 0); //readcount 조회수 초기값 = 0
			pstmt.setInt(7, bb.getRe_ref()); //re_ref 기존글의 그룹번호와 같음.
			pstmt.setInt(8, bb.getRe_lev()+1); //re_lev 답변글 들여쓰기 기존글 +1
			pstmt.setInt(9, bb.getRe_seq()+1);//re_seq 답변글 순서 기존글 +1
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			//4. 실행
			pstmt.executeUpdate();
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}	}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (con != null) {try {con.close();} catch (SQLException ex) {	}}
		}
		
	}// reInsertBoard() end
}
