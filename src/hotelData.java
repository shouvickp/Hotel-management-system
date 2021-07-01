import java.sql.*;
import javax.swing.*;

public class hotelData {
/*	public static Connection ConnectDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\deysa\\eclipse-workspace\\Hotel\\hoteldb.db");
			//JOptionPane.showMessageDialog(null, "connection Made");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "connection Error");
			return null;
		}
	}*/
	

	
	public static Connection connect()  {
		Connection connection = null;
/*		String host = "localhost";
		String port = "5432";
		String db = "MyDB";
	
	//	String url = "jdbc:postgresql://localhost/MyDB";
		String user = "postgres";
		String password = "bharat";*/
		
		try{
			Class.forName("org.postgresql.Driver");
//			connection = DriverManager.getConnection(url, user, password);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","postgres","tiger");
			if(connection != null) {
				System.out.println("Connected to PostgreSQL server successfully!");
			}
			else {
				System.out.println("Failed to connect PostgreSQL server");
			}
			

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed");
		}
		return connection;
	}
	

}


