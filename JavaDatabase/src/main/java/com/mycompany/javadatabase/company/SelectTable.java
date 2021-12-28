
package com.mycompany.javadatabase.company;

import java.sql.*;

public class SelectTable {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
   Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
   Statement mystatement = connect.createStatement();
   ResultSet output=mystatement.executeQuery("select * from company");
   while(output.next())
      {
          System.out.println(output.getString("company_name")+"  "+output.getString("based_on"));  
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
