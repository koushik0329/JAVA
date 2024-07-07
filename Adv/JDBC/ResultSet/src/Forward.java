
import java.sql.*;

public class Forward {
    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
            Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                int rollno = rs.getInt("ROLLNO");
                String name = rs.getString("name");
                // process the result set row
                System.out.println("rollno" + rollno + "name" + name);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
