package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionProvider {
	private static Connection con;
    public static Connection getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.
    				getConnection("jdbc:mysql://103.178.248.62:3306/jsptraining","root","root");
    			
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
}
