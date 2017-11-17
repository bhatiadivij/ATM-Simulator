

package source;

public class DBConnect {
    static String conString="jdbc:mysql://localhost:3306/data";
    static String User = "root";
    static String Pass = "password";
   
    static 
    {
       try
       {
         Class.forName("com.mysql.jdbc.Driver");
         
         
       }
       catch(Exception ex)
        {
           System.out.println(ex.toString());       
        }
    }
       
}
