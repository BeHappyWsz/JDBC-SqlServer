package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conn.DBUtils;
/**
 * @author wsz
 * @date 2018年1月17日
 */
public class TestDemo {

	public static void main(String[] args) {
//		select();
//		update();
//		insert();
//		delete();
	}
	
	public static void select(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String sql = "select * from s_user";
		try {
			conn = DBUtils.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				//下标从1开始或者使用标识
				System.out.println(rs.getString(1)+"_"+rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.clearResource(conn, stat, rs);
	}
	
	public static void insert(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into s_uer(name,realname,type) values(?,?,?)";//主键需要自动增长
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "1");
			ps.setString(2, "2");
			ps.setString(3, "3");
			int executeUpdate = ps.executeUpdate();
			System.out.println(executeUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.clearResource(conn, ps, rs);
	}
	
	public static void update(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update s_uer set name = ? where  name =?";
		 try {
			 conn = DBUtils.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, "aa");
			 ps.setString(2, "1");
			 int executeUpdate = ps.executeUpdate();
			 System.out.println(executeUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.clearResource(conn, ps, rs);
	}
	
	public static void delete(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from  s_uer  where name =?";
		 try {
			 conn = DBUtils.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, "aa");
			 int executeUpdate = ps.executeUpdate();
			 System.out.println(executeUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.clearResource(conn, ps, rs);
	}
}
