package project;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nutrition","root","OvinVinol##1507");
			return con;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
