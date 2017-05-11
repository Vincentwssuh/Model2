package net.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.admin.goods.db.GoodsBean;
import net.admin.goods.db.GoodsBean;

public class GoodsDAO {
	// �뵒鍮꾩뿰寃�
	private Connection getConnection() throws Exception {
		Connection con = null;
		// String url="jdbc:mysql://localhost:3306/jspdb";
		// String dbuser="jspid";
		// String dbpass="jsppass";
		// 1�떒怨� �뱶�씪�씠踰꾨줈�뜑
		// Class.forName("com.mysql.jdbc.Driver");
		// 2�떒怨� �뵒鍮꾩뿰寃�
		// con=DriverManager.getConnection(url,dbuser,dbpass);

		// 而ㅻ꽖�뀡�� : �뜲�씠�꽣踰좎씠�뒪�� �뿰寃곕맂 Connection 媛앹껜瑜� 誘몃━ �깮�꽦�븯�뿬
		// ���냽�뿉 ���옣�빐 �몢怨� �븘�슂�븷�븣留덈떎 �씠 ���뿉 �젒洹쇳븯�뿬 Connection媛앹껜 �궗�슜
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysqlDB");
		con = ds.getConnection();
		return con;
	}

	// getGoodsList()
	public List getGoodsList(String item) {
		List goodsList = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// String sql="";
		StringBuffer sql = new StringBuffer();
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql
			sql.append("select * from goods ");
			if (item.equals("all")) {
			} else if (item.equals("best")) {
				sql.append(" where best=?");
			} else {
				sql.append(" where category=?");
			}
			pstmt = con.prepareStatement(sql.toString());
			if (item.equals("all")) {
			} else if (item.equals("best")) {
				pstmt.setInt(1, 1);
			} else {
				pstmt.setString(1, item);
			}
			// 4 rs �떎�뻾 ���옣
			rs = pstmt.executeQuery();
			// 5 rs �뜲�씠�꽣 �엳�쑝硫� �옄諛붾퉰 媛앹껜 �깮�꽦
			// rs => �옄諛붾퉰 => 諛곗뿴 �븳移� ���옣
			while (rs.next()) {
				GoodsBean gBean = new GoodsBean();
				gBean.setAmount(rs.getInt("amount"));
				gBean.setBest(rs.getInt("best"));
				gBean.setCategory(rs.getString("category"));
				gBean.setColor(rs.getString("color"));
				gBean.setContent(rs.getString("content"));
				gBean.setDate(rs.getString("date"));
				gBean.setImage(rs.getString("image"));
				gBean.setName(rs.getString("name"));
				gBean.setNum(rs.getInt("num"));
				gBean.setPrice(rs.getInt("price"));
				gBean.setSize(rs.getString("size"));

				goodsList.add(gBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return goodsList;
	}

	// getGoods(num)
	public GoodsBean getGoods(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		GoodsBean gBean = null;
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql num�뿉 �빐�떦�븯�뒗 �긽�뭹媛��졇�삤湲�
			sql = "select * from goods where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4 rs �떎�뻾 ���옣
			rs = pstmt.executeQuery();
			// 5 rs �뜲�씠�꽣 �엳�쑝硫� �옄諛붾퉰 媛앹껜 �깮�꽦
			// rs => �옄諛붾퉰 ���옣
			if (rs.next()) {
				gBean = new GoodsBean();
				gBean.setAmount(rs.getInt("amount"));
				gBean.setBest(rs.getInt("best"));
				gBean.setCategory(rs.getString("category"));
				gBean.setColor(rs.getString("color"));
				gBean.setContent(rs.getString("content"));
				gBean.setDate(rs.getString("date"));
				gBean.setImage(rs.getString("image"));
				gBean.setName(rs.getString("name"));
				gBean.setNum(rs.getInt("num"));
				gBean.setPrice(rs.getInt("price"));
				gBean.setSize(rs.getString("size"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return gBean;
	}
	// updateAmount(basketList)
	// public void updateAmount(List basketList){
	// Connection con= null;
	// PreparedStatement pstmt=null;
	// ResultSet rs=null;
	// String sql="";
	// try {
	// //1,2 �뵒鍮꾩뿰寃�
	// con=getConnection();
	// // basketList for
	// //3 sql update
	// // goods�뀒�씠釉� num �뿉 �빐�떦�븯�뒗 amount �닔�젙
	// //4 �떎�뻾
	// for(int i=0;i<basketList.size();i++){
	// BasketBean basketbean=(BasketBean)basketList.get(i);
	// //3 sql
	// sql="update goods set amount=amount-? where num=?";
	// pstmt=con.prepareStatement(sql);
	// pstmt.setInt(1, basketbean.getB_g_amount());
	// pstmt.setInt(2, basketbean.getB_g_num());
	// //4�떎�뻾
	// pstmt.executeUpdate();
	// }//for
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally{
	// if(rs!=null)try{rs.close();}catch(SQLException ex){}
	// if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
	// if(con!=null)try{con.close();}catch(SQLException ex){}
	// }
	// }

}// �겢�옒�뒪
