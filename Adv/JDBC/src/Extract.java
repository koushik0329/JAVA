import java.sql.*;

public class Extract {
    public static void main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","koushikkoushik");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
//            System.out.print("table created");
            ResultSetMetaData rm=rs.getMetaData();
            int n=rm.getColumnCount();
//            System.out.println("ok");
            for(int i=1;i<=n;i++){
                System.out.print(rm.getColumnName(i)+"\t");
            }
            System.out.println();
//            while (rs.next()){
//                System.out.println(rs.getInt(1)+"\t");
//                System.out.println(rs.getString(2)+"\t");
//                System.out.println(rs.getInt(3));
//            }
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
            }

            if (!rs.next()) {
                System.out.println("No rows found");
            }


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
