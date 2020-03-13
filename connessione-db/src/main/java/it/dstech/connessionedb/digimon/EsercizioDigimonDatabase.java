package it.dstech.connessionedb.digimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EsercizioDigimonDatabase {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra
		// libreria
		String password = "password"; // la vostra password
		String username = "root"; // la vostra username
		String url = "jdbc:mysql://localhost:3306/digimon?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Scanner scanner = new Scanner(System.in);
		Connection connessione = DriverManager.getConnection(url, username, password);
		Digimon digimon = creazioneDigimon(scanner);
		if (checkInsert(digimon, connessione)) {
			insertDigimon(digimon, connessione);
		} else {
			System.out.println("Digimon già presente in banca dati");
		}

	}

	private static boolean checkInsert(Digimon digimon, Connection connessione) throws SQLException {
		PreparedStatement prepareStatement = connessione
				.prepareStatement("Select evoluzione from digimon where nome = ? and evoluzione ?;");
		prepareStatement.setString(1, digimon.getName());
		prepareStatement.setString(2, digimon.getEvo());
		ResultSet risultato = prepareStatement.executeQuery();
		while (risultato.next()) {
			if (digimon.getEvo().equals(risultato.getString("evoluzione"))) {
				return false;
			}
		}
		return true;
	}

	private static void insertDigimon(Digimon digimon, Connection connessione) throws SQLException {
		String queryInserimentoDigimon = "INSERT INTO digimon (nome, attacco, HP, difesa, resistenza, evoluzione) VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = connessione.prepareStatement(queryInserimentoDigimon);
		prepareStatement.setString(1, digimon.getName());
		prepareStatement.setInt(2, digimon.getAtk());
		prepareStatement.setInt(3, digimon.getHp());
		prepareStatement.setInt(4, digimon.getDef());
		prepareStatement.setInt(5, digimon.getRes());
		prepareStatement.setString(6, digimon.getEvo());
		prepareStatement.execute();
		

	}

	private static Digimon creazioneDigimon(Scanner scanner) {
		System.out.println("Inserisci il nome del digimon");
		String nome = scanner.nextLine();
		System.out.println("Insersci gli HP del digimon");
		int hp = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Insersci l'ATK del digimon");
		int atk = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Insersci la DEF del digimon");
		int def = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Insersci la RES del digimon");
		int res = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Inserisci lo stato evolutivo ");
		String evo = scanner.nextLine();

		return new Digimon(nome, atk, def, hp, res, evo);
	}
}
