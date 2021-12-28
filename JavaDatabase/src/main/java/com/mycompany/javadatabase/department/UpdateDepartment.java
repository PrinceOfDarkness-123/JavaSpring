
package com.mycompany.javadatabase.department;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateDepartment {
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
            System.out.println("Enter Department ID:");
            String d_id = kb.readLine();
            //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from department where id='"+d_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
         
            if(output.next()){
                System.out.println(output.getString("dept_no")+"  "+output.getString("office_id")+" "+output.getString("department_name"));  
            }else{
                System.out.println("Record Not Found...");
            }
            
            System.out.println("Update information according to id"+d_id);
            System.out.println("Office id:");
            String office_id = sc.nextLine();
            System.out.println("Department name:");
            String department_name = sc.nextLine();
            
            String sql2 = "UPDATE department SET office_id=?, department_name=? WHERE id='"+d_id+"'";
           PreparedStatement statement = connect.prepareStatement(sql2);
           statement.setString(1, office_id);
           statement.setString(2, department_name);
           
           int rowsupdated = statement.executeUpdate();
           if (rowsupdated > 0) {
    System.out.println("An existing information was updated successfully!");
}
           
            
            
      
           
      
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
