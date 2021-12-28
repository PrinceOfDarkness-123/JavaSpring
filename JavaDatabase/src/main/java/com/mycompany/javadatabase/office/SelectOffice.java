/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javadatabase.office;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SelectOffice {
   static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
   
   public static void main(String[] args){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
   Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
   Statement mystatement = connect.createStatement();
   ResultSet output=mystatement.executeQuery("select * from office");
   while(output.next())
      {
          System.out.println(output.getString("id")+"  "+output.getString("company_id")+" "+output.getString("office_name")+" "+output.getString("office_location"));  
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
