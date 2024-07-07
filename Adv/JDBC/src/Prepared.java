import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prepared {
    public static void  main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","koushikkoushik");
            PreparedStatement pt=con.prepareStatement("insert into student values(?,?,?)");
            pt.setInt(1,Integer.parseInt(args[0]));
            pt.setString(2,args[1]);
            pt.setInt(3,Integer.parseInt(args[2]));
            pt.executeUpdate();
            System.out.println("one row updated");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
