import java.sql.*;

public class Batch {
    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
            Statement stmt = con.createStatement();
            stmt.addBatch("insert into student values(7,'asd',33)");
            stmt.addBatch("update student set marks=75 where rollno=3");
            stmt.addBatch("delete from student where rollno=4");
            stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
