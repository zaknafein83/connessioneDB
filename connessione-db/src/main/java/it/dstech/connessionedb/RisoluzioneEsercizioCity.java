package it.dstech.connessionedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RisoluzioneEsercizioCity {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
													// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		PreparedStatement prepareStatement = connessione
				.prepareStatement("select distinct GovernmentForm from country;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<String> elencoFormeDiGoverno = new ArrayList<>();
		int cnt = 0;
		while (executeQuery.next()) {
			String formaDiGoverno = executeQuery.getString(1);
			elencoFormeDiGoverno.add(formaDiGoverno);
			System.out.println(cnt + ". " + formaDiGoverno);
			cnt++;
		}
		System.out.println("Indica quale forma di governo vuoi vedere lo stato più grande");
		int posizione = scanner.nextInt();
		scanner.nextLine();
		String stato = elencoFormeDiGoverno.get(posizione);
		PreparedStatement altroStatement = connessione.prepareStatement("select *, MAX(SurfaceArea)  kmq from country where GovernmentForm = ?");
		altroStatement.setString(1, stato);
		ResultSet executeQuery2 = altroStatement.executeQuery();
		
		while (executeQuery2.next()) {
			String formaDiGoverno = executeQuery2.getString("name");
			String superficie = executeQuery2.getString("kmq");
			System.out.println(superficie + " - " + formaDiGoverno);
		}
		scanner.close();

	}
}
