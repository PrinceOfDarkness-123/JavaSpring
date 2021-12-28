
package com.mycompany.javadatabase.office;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DeleteOffice {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
   
    public static void main(String[] args) {
        try {
            System.out.println("Enter office id to delete information");
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement mystatement = connect.createStatement();
        DataInputStream kb= new DataInputStream(System.in);
        String o_id = kb.readLine();
        //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from office where id='"+o_id+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
            
            
            
            if(output.next()){
                System.out.println(output.getString("id")+"  "+output.getString("company_id")+" "+output.getString("office_name")+" "+output.getString("office_location"));  
            }else{
                System.out.println("Record Not Found...");
            }
            String query = "delete from company where id = '"+o_id+"'";
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.executeUpdate();
            System.out.println("row deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
