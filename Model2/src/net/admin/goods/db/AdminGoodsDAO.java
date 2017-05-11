package net.admin.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminGoodsDAO {
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

	// insertGoods(gBean)硫붿꽌�뱶
	public void insertGoods(GoodsBean gBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		int num = 0;
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// num援ы븯湲�
			sql = "select max(num) from goods";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}
			// 3 sql insert
			sql = "insert into goods(num,category,name,content,size,color,amount,price,image,best,date) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, gBean.getCategory());
			pstmt.setString(3, gBean.getName());
			pstmt.setString(4, gBean.getContent());
			pstmt.setString(5, gBean.getSize());
			pstmt.setString(6, gBean.getColor());
			pstmt.setInt(7, gBean.getAmount());
			pstmt.setInt(8, gBean.getPrice());
			pstmt.setString(9, gBean.getImage());
			pstmt.setInt(10, gBean.getBest());
			// 4 �떎�뻾
			pstmt.executeUpdate();
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
	}// 硫붿꽌�뱶

	// getGoodsList()硫붿꽌�뱶
	public List getGoodsList() {
		List goodsList = new ArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql
			sql = "select * from goods";
			pstmt = con.prepareStatement(sql);
			// 4 rs �떎�뻾 ���옣
			rs = pstmt.executeQuery();
			// 5 rs�뜲�씠�꽣 �엳�쑝硫� �옄諛붾퉰 媛앹껜 �깮�꽦 gBean
			// rs => �옄諛붾퉰 硫ㅻ쾭蹂��닔 ���옣 => goodsList �븳移� ���옣
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
				// �옄諛붾퉰 => 諛곗뿴 �븳移� ���옣
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

	// modifyGoods(GoodsBean goodsbean)
	public void modifyGoods(GoodsBean goodsbean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql num �뿉 �빐�떦�븯�뒗
			// category name price color amount size best content�닔�젙
			sql = "update goods set category=?,name=?,price=?,color=?,amount=?,size=?,best=?,content=? where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsbean.getCategory());
			pstmt.setString(2, goodsbean.getName());
			pstmt.setInt(3, goodsbean.getPrice());
			pstmt.setString(4, goodsbean.getColor());
			pstmt.setInt(5, goodsbean.getAmount());
			pstmt.setString(6, goodsbean.getSize());
			pstmt.setInt(7, goodsbean.getBest());
			pstmt.setString(8, goodsbean.getContent());
			pstmt.setInt(9, goodsbean.getNum());
			// 4�떎�뻾
			pstmt.executeUpdate();
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
	}

	// deleteGoods(int num)
	public void deleteGoods(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql num�빐�떦�븯�뒗 �긽�뭹 �궘�젣
			sql = "delete from goods where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4 �떎�뻾
			pstmt.executeUpdate();
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
	}

	// getGoods(int num)
	public GoodsBean getGoods(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		GoodsBean goodsbean = null;
		try {
			// 1,2 �뵒鍮꾩뿰寃�
			con = getConnection();
			// 3 sql num�뿉 �빐�떦�븯�뒗 �긽�뭹�젙蹂� 媛��졇�삤湲�
			sql = "select * from goods where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4 rs �떎�뻾 ���옣
			rs = pstmt.executeQuery();
			// 5 �뜲�씠�꽣 �엳�쑝硫� �옄諛붾퉰媛앹껜 �깮�꽦
			// rs => �옄諛붾퉰 ���옣
			if (rs.next()) {
				goodsbean = new GoodsBean();
				goodsbean.setAmount(rs.getInt("amount"));
				goodsbean.setBest(rs.getInt("best"));
				goodsbean.setCategory(rs.getString("category"));
				goodsbean.setColor(rs.getString("color"));
				goodsbean.setContent(rs.getString("content"));
				goodsbean.setDate(rs.getString("date"));
				goodsbean.setImage(rs.getString("image"));
				goodsbean.setName(rs.getString("name"));
				goodsbean.setNum(rs.getInt("num"));
				goodsbean.setPrice(rs.getInt("price"));
				goodsbean.setSize(rs.getString("size"));
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
		return goodsbean;
	}

}// �겢�옒�뒪
