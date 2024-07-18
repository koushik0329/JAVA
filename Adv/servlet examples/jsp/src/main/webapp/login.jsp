
<html>

<body>
<%!
java.sql.Connection con;
public void jspInit(){
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","koushikkoushik");
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
<% 
String s1=request.getParameter("uname");
String s2=request.getParameter("pword");
java.sql.PreparedStatement pt=con.prepareStatement("select * from uinfo where uname=? and pword=?");
pt.setString(1,s1);
pt.setString(2,s2);
java.sql.ResultSet rs=pt.executeQuery();
if(rs.next()){
	out.println("welcome"+s1);
}
else{
	out.println("invalid");
}
%>
<%!
 public void jspDestroy(){
 try{
	 con.close();
 }
 catch(Exception e){
	 e.printStackTrace();
 }
 }
 %>

</body>
</html>