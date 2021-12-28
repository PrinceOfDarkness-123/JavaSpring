
package com.mycompany.javadatabase.job;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DeleteJob {
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
        String j_id = kb.readLine();
        //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from job where id='"+j_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
            
            
            
            if(output.next()){
               System.out.println(output.getString("dept_id")+"  "+output.getString("job_title")+" "+output.getString("job_description"));
            }else{
                System.out.println("Record Not Found...");
            }
            String query = "delete from job where id = '"+j_id+"'";
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.executeUpdate();
            System.out.println("row deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

