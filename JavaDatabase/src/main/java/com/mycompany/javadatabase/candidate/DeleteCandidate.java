
package com.mycompany.javadatabase.candidate;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteCandidate {
     static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
        try {
            System.out.println("Enter job id to delete information");
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement mystatement = connect.createStatement();
        DataInputStream kb= new DataInputStream(System.in);
        String c_id = kb.readLine();
    
            String sql="Select * from candidate where id='"+c_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
            
            
            
            if(output.next()){
                System.out.println(output.getString("id")+"  "+output.getString("job_id")+" "+output.getString("candidate_name")+" "+output.getString("candidate_age") + " "+output.getString("candidate_phone_no"));  
            }else{
                System.out.println("Record Not Found...");
            }
            String query = "delete * from candidate where id = '"+c_id+"'";
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.executeUpdate();
            System.out.println("row deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
