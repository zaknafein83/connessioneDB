package it.dstech.connessionedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnessioneDatabase {
	
	/*
	 * Username: 2QmHgYocHj

Database name: 2QmHgYocHj

Password: qNujd585zn

Server: remotemysql.com

Port: 3306

These are the username and password to log in to your database and phpMyAdmin


	 */

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // in questo punto carichia nella JVM in esecuzione la nostra libreria 
		String password ="qNujd585zn"; // la vostra password
		String username = "2QmHgYocHj"; // la vostra username
		String url = "jdbc:mysql://remotemysql.com:3306/2QmHgYocHj?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, username, password);
		Statement statement = connessione.createStatement();
		ResultSet risultatoQuery = statement.executeQuery("select * from city where CountryCode =  \"ITA\" ;");
		while(risultatoQuery.next()) {
			int id = risultatoQuery.getInt(1);
			String nome = risultatoQuery.getString("Name");
			int pop = risultatoQuery.getInt(5);
			System.out.println(id + " " + nome + " - " + pop);
		}
		
	}
}
