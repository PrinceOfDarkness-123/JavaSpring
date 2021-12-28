
package com.mycompany.javadatabase.candidate;


public class SelectCandidate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javabackenddatabase";
   static final String USER = "root";
   static final String PASS = "amm123!#=/+";
    public static void main(String[] args) {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
   Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
   Statement mystatement = connect.createStatement();
   ResultSet output=mystatement.executeQuery("select * from candidate");
   while(output.next())
      {
          System.out.println(output.getString("id")+"  "+output.getString("job_id")+" "+output.getString("candidate_name")+" "+output.getString("candidate_age") + " "+output.getString("candidate_phone_no"));  
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
