//6월 8일 - 16

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectTestemp {

	public static void main(String[] args) {
		
		Connection con = null;    //select 구문 전용
		Statement stmt = null;    //select 구문 전
		ResultSet rs = null;      //select 구문 전용
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from emp";
		
		try {          //2단계: 예외처리해주기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("연결 성공");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);  //executeQuery(): select ,   executeUpdate(): insert,update,delete
			
			while(rs.next()) {
				String empno = rs.getString("empno");   
				String ename = rs.getString("ename");  
				String job =rs.getString("job"); 
				String mgr =rs.getString("mgr"); 
				Date hiredate = rs.getDate("hiredate");
				Integer sal = rs.getInt("sal");
				Integer comm = rs.getInt("comm");
				Integer deptno = rs.getInt("deptno");
				
				System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hiredate + " : " + sal + " : " + comm + " : " + deptno);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}

	
	
	
	
	
	
	
	
	
	}

}
