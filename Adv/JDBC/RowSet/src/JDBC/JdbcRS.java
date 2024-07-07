

package JDBC;

import oracle.jdbc.rowset.OracleJDBCRowSet;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;



public class JdbcRS {
    public static void main(String args[]){
        try{
            JdbcRowSet jrs=new OracleJDBCRowSet();
//            jrs.setURL();
            jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            jrs.setUsername("System");
            jrs.setPassword("koushikkoushik");
            jrs.setCommand("select * from student");
            jrs.execute();
            while(jrs.next()){
                System.out.println(jrs.getInt("rollno")+"\t");
                System.out.println(jrs.getString("name")+"\t");
                System.out.println(jrs.getInt("marks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
