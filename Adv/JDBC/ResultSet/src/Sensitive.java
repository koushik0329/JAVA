import java.sql.*;

public class Sensitive {
    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            String insertSQL="insert into student (ROLLNO, NAME, MARKS) values (9,'as',77)";
            stmt.executeUpdate(insertSQL);


//            rs.moveToInsertRow();
//
//
//            rs.updateInt("ROLLNO", 9);
//            rs.updateString("NAME", "John Doe");
//            rs.updateInt("MARKS", 85);
//
//
//            rs.insertRow();
//
//
//            rs.beforeFirst();


//            while (rs.next()) {
//                System.out.println("rollno: " + rs.getInt("ROLLNO") + ", Name: " + rs.getString("NAME") + ", Marks: " + rs.getInt("MARKS"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
