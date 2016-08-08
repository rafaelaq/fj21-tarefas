package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Usuario;

public class UsuarioDao {
	
	private final Connection connection;
	
	public UsuarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean existeUsuario(Usuario usuario){
		boolean existe = false;
		String sql = "select * from usuarios where login = ?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			System.out.println(usuario.getLogin());
			ResultSet result = stmt.executeQuery();
			
			while(result.next()){
				existe = true;
			}
			result.close();
			stmt.close();
		} catch(Exception e){
			throw new RuntimeException();
		}
		return existe;
	}
}
