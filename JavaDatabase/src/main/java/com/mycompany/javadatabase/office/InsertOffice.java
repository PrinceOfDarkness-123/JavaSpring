
package com.mycompany.javadatabase.office;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertOffice {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
   
   public static void main(String[] args){
       Scanner sc =new Scanner(System.in);
        try {
            System.out.println("Enter company id");
            String company_id = sc.nextLine();
            System.out.println("Enter office name:");
            String office_name = sc.nextLine();
            System.out.println("Enter office location");
            String office_location = sc.nextLine();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement pst = connect.prepareStatement("insert into office(company_id, office_name, office_location) values (?,?,?)");
            pst.setString(1, company_id);
            pst.setString(2, office_name);
            pst.setString(3, office_location);
            
            
            
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
