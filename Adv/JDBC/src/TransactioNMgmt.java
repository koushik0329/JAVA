import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactioNMgmt{
    public static void main(String ars[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
            System.out.println(con.getAutoCommit());
            con.setAutoCommit(false);
            System.out.println(con.getAutoCommit());
            Statement s= con.createStatement();
            Savepoint st= con.setSavepoint();
            s.executeUpdate("insert into student values(11,'asd',67)");
            con.rollback(st);
            System.out.println("inserted");
            System.out.println(con.getAutoCommit());
            con.commit();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}