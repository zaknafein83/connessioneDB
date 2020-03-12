package it.dstech.connessionedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PreparedStatementQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
													// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select * from city where CountryCode =  ? and Population  > ?;");
//		List<E>
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inseriscimi lo stato di interesse");
		prepareStatement.setString(1, scanner.nextLine());
		System.out.println("Dammi la popolazione minima");
		prepareStatement.setInt(2, scanner.nextInt());
		scanner.nextLine();
		ResultSet risultatoQuery = prepareStatement.executeQuery();
		while (risultatoQuery.next()) {
			int id = risultatoQuery.getInt(1);
			String nome = risultatoQuery.getString("Name");
			int pop = risultatoQuery.getInt(5);
			System.out.println(id + " " + nome + " - " + pop);
		}
	}
}
