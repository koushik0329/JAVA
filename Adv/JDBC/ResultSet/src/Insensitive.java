
import java.sql.*;


public class Insensitive {
    public static void main(String args[]){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
            // Create a statement that supports scrollable, insensitive result sets
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Execute a query and get the result set
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Move the cursor to the last row of the result set
            rs.last();

            // Print the ID of the last row
            int rollno = rs.getInt("ROLLNO");
            System.out.println("Last row ID: " +rollno);

            // Move the cursor to the first row of the result set
            rs.beforeFirst();

            // Iterate over the result set and print each row
            while (rs.next()) {
                System.out.println("rollno: " + rs.getInt("ROLLNO") + ", Name: " + rs.getString("NAME"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
