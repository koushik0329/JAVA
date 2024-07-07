import java.sql.*;
class Demo{
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","koushikkoushik");
			Statement st=con.createStatement();
			boolean b=st.execute("create table student(rollno number(3), name varchar2(10), marks number(3))");
			System.out.print("table created");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}