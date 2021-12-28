
package com.mycompany.javadatabase.candidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertCandidate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
   
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       try {
            System.out.println("Enter job id");
            String job_id = sc.nextLine();
            System.out.println("Enter Candidate name:");
            String candidate_name = sc.nextLine();
            System.out.println("Enter Candidate age:");
            String candidate_age = sc.nextLine();
            System.out.println("Enter candidate phone number:");
            String candidate_phone_number = sc.nextLine();
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement pst = connect.prepareStatement("insert into candidate(job_id, candidate_name, candidate_age, candidate_phone_no) values (?,?,?,?)");
            pst.setString(1, job_id);
            pst.setString(2, candidate_name);
            pst.setString(3, candidate_age);
            pst.setString(4, candidate_phone_number);
            
            
            
            
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
