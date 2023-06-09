//6월 8일 - 15  ,   //6월 9일 - 1

//1단계 : 임포트해주기 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcConnectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;    //select 구문 전용
		Statement stmt = null;    //select 구문 전
		ResultSet rs = null;      //select 구문 전용
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql1 = "select * from emp01";
		//String sql2 = "insert into emp01" + " values (2222,'Kim','SALES',7788,sysdate,1000,null,30)";
		//values 앞에 한 칸 띄어서 " values 라고 해줘야됨. 그렇지 않으면 테이블을  emp01values로 인식함
		//String sql3 = "update emp01" + " set empno = 3333" + " where empno = 1111";
		String sql4 = "delete from emp01 where empno = 2222";
		
		
		try {          //2단계: 예외처리해주기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("연결 성공");
			
			stmt = con.createStatement();
			//int result = stmt.executeUpdate(sql2);   //실행한 쿼리문이 잘 동작했는지 
			//int result = stmt.executeUpdate(sql3);
			int result = stmt.executeUpdate(sql4);
			
			if(result <= 0) {                                  
				System.out.println("테이터 처리 실패");
			}else {
				System.out.println("데이터 처리 성공");
			}
			
			rs = stmt.executeQuery(sql1);  //executeQuery(): select ,   executeUpdate(): insert,update,delete
			
			while(rs.next()) {
				int empno = rs.getInt(1);//rs.getInt("deptno");   
				String ename =rs.getString(2);// rs.getString("dname"); 
				String job =rs.getString(3);//rs.getString("loc"); 
				
				System.out.println(empno + " : " + ename + " : " + job);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
