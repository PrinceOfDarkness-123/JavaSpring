
package com.mycompany.javadatabase.company;

import java.sql.*;
import java.util.Scanner;


public class InsertionofTable {
   static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try {
            System.out.println("Enter company name:");
            String name = sc.nextLine();
            System.out.println("Based on what:");
            String based = sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement pst = connect.prepareStatement("insert into company(company_name, based_on) values (?,?)");
            pst.setString(1, name);
            pst.setString(2, based);
            
            
            int i = pst.executeUpdate();
            if (i!=0) {
                System.out.println("added");
            } else {
                System.out.println("failed");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
