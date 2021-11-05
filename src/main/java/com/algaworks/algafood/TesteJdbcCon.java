package com.algaworks.algafood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteJdbcCon {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
      //Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/algafood?createDatabaseIfNotExist=true&serverTimezone=UTC"
				,"root","root");
		
		System.out.println("ok");
		
	}

}
