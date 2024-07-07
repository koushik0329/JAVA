import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Callable {
    public static void  main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","koushikkoushik");
//            PreparedStatement pt=con.prepareStatement("insert into student values(?,?,?)");
            CallableStatement ct=con.prepareCall("{call insertpro(?,?,?)}");
            ct.setInt(1,Integer.parseInt(args[0]));
            ct.setString(2,args[1]);
            ct.setInt(3,Integer.parseInt(args[2]));
            ct.executeUpdate();
            System.out.println("one row updated");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
