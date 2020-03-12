package it.dstech.connessionedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaDiegoDifferentiResultSet {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
		// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement prepareStatement = connessione.prepareStatement("select * from country limit 10;");
		ResultSet primoResultSet = prepareStatement.executeQuery();
		PreparedStatement secondoPrepareStatement = connessione.prepareStatement("select * from city limit 1;");
		ResultSet secondoResultSet = secondoPrepareStatement.executeQuery();
		
		while (primoResultSet.next() && secondoResultSet.next()) {
			System.out.println(primoResultSet.getString(2) + " - "  + secondoResultSet.getString(2));
		}

	}
}
