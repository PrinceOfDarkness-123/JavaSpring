
package com.mycompany.javadatabase.candidate;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
public class UpdateCandidate {
    Scanner sc =new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement mystatement = connect.createStatement();
            
            DataInputStream kb= new DataInputStream(System.in);
            //input a particular employee id of which we want to display record
            System.out.println("Enter Candidate ID:");
            String c_id = kb.readLine();
            //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from candidate where id='"+c_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
         
            if(output.next()){
                 System.out.println(output.getString("id")+"  "+output.getString("job_id")+" "+output.getString("candidate_name")+" "+output.getString("candidate_age") + " "+output.getString("candidate_phone_no")); 
                 System.out.println("Update information according to id"+c_id);
            System.out.println("job_id.:");
            String job_id = sc.nextLine();
            System.out.println("candidate_name:");
            String candidate_name = sc.nextLine();
            System.out.println("candidate_age:");
            String candidate_age = sc.nextLine();
            System.out.println("candidate phone number:");
            String candidate_phone_no = sc.nextLine();
            
            String sql2 = "UPDATE candidate SET job_id=?, candidate_name=?, candidate_age=?, candidate_phone_no=? WHERE id='"+c_id+"'";
           PreparedStatement statement = connect.prepareStatement(sql2);
           statement.setString(1, job_id);
           statement.setString(2, candidate_name);
           statement.setString(3, candidate_age);
           statement.setString(3, candidate_phone_no);
           
           int rowsupdated = statement.executeUpdate();
           if (rowsupdated > 0) {
    System.out.println("An existing information was updated successfully!");
}
           else{
               System.out.println("Failed to update");
           }
        }   else{
                System.out.println("Record Not Found...");
            }
            
            
           
            
            
      
           
      
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
