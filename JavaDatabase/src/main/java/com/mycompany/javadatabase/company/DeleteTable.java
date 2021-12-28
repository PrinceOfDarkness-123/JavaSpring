
package com.mycompany.javadatabase.company;


import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class DeleteTable {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) throws IOException{
        
        try {
            System.out.println("Enter employee id to delete information");
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement mystatement = connect.createStatement();
        DataInputStream kb= new DataInputStream(System.in);
        String eid = kb.readLine();
        //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from company where id='"+eid+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
            
            
            
            if(output.next()){
                System.out.println(output.getString("company_name")+"  "+output.getString("based_on")); 
            }else{
                System.out.println("Record Not Found...");
            }
            String query = "delete from company where id = '"+eid+"'";
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.executeUpdate();
            System.out.println("row deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
