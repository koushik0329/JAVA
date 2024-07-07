import java.sql.*;

public class UpdateExample {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");

            // Create a statement with updatable ResultSet
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM student");

            // Loop through the result set
            while (rs.next()) {
                // Check if the row matches the criteria for updating
                if (rs.getInt("ROLLNO") == 9) {
                    // Update the columns
                    rs.updateString("NAME", "Jane Doe");
                    rs.updateInt("MARKS", 95);
                    // Commit the updates
                    rs.updateRow();
                }
            }

            // Move cursor to the start
            rs.beforeFirst();
            // Print the updated result set
            while (rs.next()) {
                System.out.println("ROLLNO: " + rs.getInt("ROLLNO") + ", NAME: " + rs.getString("NAME") + ", MARKS: " + rs.getInt("MARKS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
