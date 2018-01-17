package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author wsz
 * @date 2018年1月17日
 */
public class DBUtils {

	private static final String USER ="wsz"; 
	private static final String PWD ="wsz"; 
	private static final String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	private static final String URL ="jdbc:sqlserver://localhost:1033; DatabaseName=TEST"; //端口1033，数据库TEST
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void clearResource(Connection conn,PreparedStatement ps, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(ps != null){
				ps.close();
				ps = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void clearResource(Connection conn,Statement stat, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(stat != null){
				stat.close();
				stat = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
