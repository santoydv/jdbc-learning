//first step
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

public class Main{
   static void main() {
        /*
            **JDBC Steps**
            import package
            load and register driver
            create connection
            create statement
            execute statement
            process the results
            close
        */

       String url = "jdbc:postgresql://localhost:5432/jdbcdemo";
       String username = "postgres";
       String password = "0000";

       //load and register driver
       try {
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

       //create a connection, this is optional anyway
       Connection con;
       try {
           con = DriverManager.getConnection(url,username,password);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       System.out.println("Connection Established");

       //creating statement
       //String query = "SELECT name FROM student";
       //String query = "SELECT * FROM student";
       String query = "INSERT INTO student(id,name,age) values (5,'Sanjit',26);";
       //Prepared Statement
       //PreparedStatement st = con.prepareStatement(query);
       // int sid = 6, sage = 27;
       //String sname = Kunal;
       // sql = "insert into student values (?,?,?)";
       //st.setInt(1,sid);
       //st.setString(2,sname);
       //st.setInt(3,sage);
       Statement st;
       try {
           st = con.createStatement();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       //execute statement
       //ResultSet rs;
       boolean status;
       try {
           //rs = st.executeQuery(query);
           status = st.execute(query);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       //process the result
       //List<String> names = new ArrayList<>();
//       try {
//           while (rs.next()) {
//               //names.add(rs.getString("name"));
//               int id = rs.getInt(1);
//               String name = rs.getString((2));
//               int age = rs.getInt(3);
//               System.out.println(id + " " + name + " " + age);
//           }
//       } catch (SQLException e) {
//           throw new RuntimeException(e);
//       }



//       for(String name : names){
//           System.out.println(name);
//       }
       System.out.println(status);

       //close the connection
       try {
           con.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       System.out.println("Connection Closed");
   }
}
