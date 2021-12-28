
package com.mycompany.javadatabase.company;



import java.io.DataInputStream;
import java.util.Scanner;
import java.sql.*;

public class UpdateTable {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement mystatement = connect.createStatement();
            
            DataInputStream kb= new DataInputStream(System.in);
            //input a particular employee id of which we want to display record
            System.out.println("Enter Company ID:");
            String eid = kb.readLine();
            //query to display a particular record from table employee where empid(employee id) is equals to eid
            String sql="Select * from company where id='"+eid+"'";
            
            ResultSet output = mystatement.executeQuery(sql);
   
         
            if(output.next()){
                System.out.println(output.getString("company_name")+"  "+output.getString("based_on")); 
            }else{
                System.out.println("Record Not Found...");
            }
            
            System.out.println("Update information according to id"+eid);
            System.out.println("Company name:");
            String name = sc.nextLine();
            System.out.println("Update based on:");
            String based = sc.nextLine();
            String sql2 = "UPDATE company SET company_name=?, based_on=? WHERE id='"+eid+"'";
           PreparedStatement statement = connect.prepareStatement(sql2);
           statement.setString(1, name);
           statement.setString(2, based);
           int rowsupdated = statement.executeUpdate();
           if (rowsupdated > 0) {
    System.out.println("An existing user was updated successfully!");
}
           
            
            
      
           
      
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
