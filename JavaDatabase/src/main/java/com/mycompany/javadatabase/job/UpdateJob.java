package com.mycompany.javadatabase.job;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateJob {
     static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement mystatement = connect.createStatement();
            
            DataInputStream kb= new DataInputStream(System.in);
            //input a particular employee id of which we want to display record
            System.out.println("Enter Job ID:");
            String j_id = kb.readLine();
            //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from job where id='"+j_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
         
            if(output.next()){
                System.out.println(output.getString("id")+"  "+output.getString("dept_id")+" "+output.getString("job_title")+" "+output.getString("job_description")); 
                System.out.println("Update information according to id"+j_id);
            System.out.println("Dept no.:");
            String dept_id = sc.nextLine();
            System.out.println("Job Title:");
            String job_title = sc.nextLine();
            System.out.println("Job Description:");
            String job_description = sc.nextLine();
            
            String sql2 = "UPDATE job SET dept_id=?, job_title=?, job_description=? WHERE id='"+j_id+"'";
           PreparedStatement statement = connect.prepareStatement(sql2);
           statement.setString(1, dept_id);
           statement.setString(2, job_title);
           statement.setString(3, job_description);
           
           int rowsupdated = statement.executeUpdate();
           if (rowsupdated > 0) {
    System.out.println("An existing information was updated successfully!");
              }else{
               System.out.println("Failed to update");
           }
      }
            else{
               System.out.println("Record Not Found...");
            }
            
            
           
            
            
      
           
      
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

