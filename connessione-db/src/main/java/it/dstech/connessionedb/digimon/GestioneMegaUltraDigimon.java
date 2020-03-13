package it.dstech.connessionedb.digimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneMegaUltraDigimon {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
		// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/digimon?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select * from digimon where evoluzione = ? ; ");
		prepareStatement.setString(1, "MEGAEVO");
		while(true) {
			
			Thread.sleep(5000);
			
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()) {
				System.out.println(executeQuery.getString(2));
			}
		}

	}

}
