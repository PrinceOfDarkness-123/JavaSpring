
package com.mycompany.javadatabase.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JavaDatabase {
    

   static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    
    
    public static void main(String[] args) {
        //open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ) {
            String company_table = "CREATE TABLE COMPANY "+
                    "(id INTEGER not Null AUTO_INCREMENT, "+
                    "company_name VARCHAR(255) not Null, "+
                    "based_on VARCHAR(255) not Null, "+
                     "PRIMARY KEY (id))";
            String office_table = "CREATE TABLE OFFICE "+
                    "(id INTEGER not Null AUTO_INCREMENT, "+
                    "company_id INTEGER not Null, "+
                    "office_name VARCHAR(255) not Null, "+
                    "office_location VARCHAR(255) not Null, "+
                     "PRIMARY KEY (id))";
            String department_table = "CREATE TABLE DEPARTMENT "+
                    "(id INTEGER not Null AUTO_INCREMENT, "+
                    "company_id INTEGER not Null, "+
                    "department_name VARCHAR(255) not Null, "+
                     "PRIMARY KEY (id))";
            String job_table = "CREATE TABLE JOB "+
                    "(id INTEGER not Null AUTO_INCREMENT, "+
                    "dept_id INTEGER not Null, "+
                    "job_title VARCHAR(255) not Null, "+
                    "job_description VARCHAR(255) not Null, "+
                     "PRIMARY KEY (id))";
            String candidate_table = "CREATE TABLE CANDIDATE "+
                    "(id INTEGER not Null AUTO_INCREMENT, "+
                    "job_id INTEGER not Null, "+
                    "candidate_name VARCHAR(255) not Null, "+
                    "candidate_age VARCHAR(255) not Null, "+
                    "candidate_phone_no VARCHAR(255) not Null, "+
                     "PRIMARY KEY (id))";
            stmt.executeUpdate(company_table);
            stmt.executeUpdate(office_table);
            stmt.executeUpdate(department_table);
            stmt.executeUpdate(job_table);
            stmt.executeUpdate(candidate_table);
            
            
            
            
            System.out.println("All tables created");
            
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
    }
    

}
