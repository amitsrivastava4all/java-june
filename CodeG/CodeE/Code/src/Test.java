import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver is Loaded.");
		// jdbc:postgresql://hostname:port/dbname
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","amit","amit123");
		System.out.println("Connection Created");
		

	}

}
