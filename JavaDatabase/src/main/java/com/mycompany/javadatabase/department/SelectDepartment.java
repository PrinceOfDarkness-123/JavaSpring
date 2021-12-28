
package com.mycompany.javadatabase.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SelectDepartment {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
   Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
   Statement mystatement = connect.createStatement();
   ResultSet output=mystatement.executeQuery("select * from department");
   while(output.next())
      {
          System.out.println(output.getString("dept_no.")+"  "+output.getString("office_id")+" "+output.getString("department_name"));  
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
