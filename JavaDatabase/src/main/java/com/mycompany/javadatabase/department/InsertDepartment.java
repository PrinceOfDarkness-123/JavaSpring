
package com.mycompany.javadatabase.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertDepartment {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try {
            System.out.println("Enter office id");
            String office_id = sc.nextLine();
            System.out.println("Enter department name:");
            String department_name = sc.nextLine();
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement pst = connect.prepareStatement("insert into department(office_id, department_name) values (?,?)");
            pst.setString(1, office_id);
            pst.setString(2, department_name);
            
            
            
            
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
