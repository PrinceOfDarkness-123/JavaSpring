
package com.mycompany.javadatabase.office;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateOffice {
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
            System.out.println("Enter Office ID:");
            String o_id = kb.readLine();
            //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from office where id='"+o_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
         
            if(output.next()){
                System.out.println(output.getString("id")+"  "+output.getString("company_id")+" "+output.getString("office_name")+" "+output.getString("office_location"));  
            }else{
                System.out.println("Record Not Found...");
            }
            
            System.out.println("Update information according to id"+o_id);
            System.out.println("company id:");
            String company_id = sc.nextLine();
            System.out.println("Office name:");
            String office_name = sc.nextLine();
            System.out.println("Office location:");
            String office_location = sc.nextLine();
            String sql2 = "UPDATE office SET company_id=?, office_name=?, office_location=? WHERE id='"+o_id+"'";
           PreparedStatement statement = connect.prepareStatement(sql2);
           statement.setString(1, company_id);
           statement.setString(2, office_name);
           statement.setString(3, office_location);
           int rowsupdated = statement.executeUpdate();
           if (rowsupdated > 0) {
    System.out.println("An existing information was updated successfully!");
}
           
            
            
      
           
      
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    }

