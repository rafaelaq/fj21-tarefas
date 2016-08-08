package br.com.caelum.tarefas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection("jdbc:mysql://localhost/banco","root", "qwe123");
	}

}
