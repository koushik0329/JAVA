package JDBC;

import oracle.jdbc.rowset.OracleWebRowSet;

import javax.sql.rowset.WebRowSet;
import java.io.FileOutputStream;



public class WebRS {
    public static void main(String args[]){
        try{
            WebRowSet jrs=new OracleWebRowSet();
//            jrs.setURL();
            jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            jrs.setUsername("System");
            jrs.setPassword("koushikkoushik");
            jrs.setCommand("select * from student");
            jrs.execute();
            FileOutputStream fis=new FileOutputStream("WebRS.xml");
            jrs.writeXml(fis);
//            while(jrs.next()){
//                System.out.println(jrs.getInt("rollno")+"\t");
//                System.out.println(jrs.getString("name")+"\t");
//                System.out.println(jrs.getInt("marks"));
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
