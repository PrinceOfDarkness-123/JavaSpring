
package com.mycompany.javadatabase.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertJob {
     static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try {
            System.out.println("Enter department id");
            String dept_id = sc.nextLine();
            System.out.println("Enter Job Title:");
            String job_title = sc.nextLine();
            System.out.println("Enter Job description:");
            String job_description = sc.nextLine();
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement pst = connect.prepareStatement("insert into job(dept_id, job_title, job_description) values (?,?,?)");
            pst.setString(1, dept_id);
            pst.setString(2, job_title);
            pst.setString(3, job_description);
            
            
            
            
            
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
