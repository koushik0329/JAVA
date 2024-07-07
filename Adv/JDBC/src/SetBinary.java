import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SetBinary {
    public static void main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","koushikkoushik");
            PreparedStatement pt=con.prepareStatement("insert into images values(?,?)");
            pt.setString(1, args[0]);
            FileInputStream fis=new FileInputStream(args[1]);
            pt.setBinaryStream(2,fis,fis.available());
            pt.executeUpdate();
            System.out.println("inserted one");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
