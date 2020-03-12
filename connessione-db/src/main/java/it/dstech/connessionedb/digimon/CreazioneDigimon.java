package it.dstech.connessionedb.digimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreazioneDigimon {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
		// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/digimon?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Scanner scanner = new Scanner(System.in);
		Connection connessione = DriverManager.getConnection(url, username, password);
		String queryInserimentoDigimon = "INSERT INTO digimon (nome, attacco, difesa, resistenza, evoluzione) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoDigimon);
		System.out.println("Inserisci il nome");
		prepareStatement.setString(1, scanner.nextLine());
		System.out.println("Inserisci l'attacco");
		prepareStatement.setInt(2, scanner.nextInt());
		scanner.nextLine();
		System.out.println("Inserisci la difesa");
		prepareStatement.setInt(3, scanner.nextInt());
		scanner.nextLine();
		System.out.println("Inserisci la resistenza");
		prepareStatement.setInt(4, scanner.nextInt());
		scanner.nextLine();
		System.out.println("Inserisci l'evoulizone");
		prepareStatement.setString(5, scanner.nextLine());
		prepareStatement.execute();
		scanner.close();
		
	}
}
