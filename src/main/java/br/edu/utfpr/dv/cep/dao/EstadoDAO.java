package br.edu.utfpr.dv.cep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.cep.model.Estado;

public class EstadoDAO {
	
	public List<Estado> listar() throws SQLException{
		Statement stmt = Conexao.getInstance().getConexao().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM state ORDER BY title");
		List<Estado> list = new ArrayList<Estado>();
		
		while(rs.next()){
			Estado e = new Estado();
			
			e.setId(rs.getInt("id"));
			e.setNome(rs.getString("title"));
			e.setSigla(rs.getString("letter"));
			
			list.add(e);
		}
		
		return list;
	}

	public List<Estado> listarPorPopulacao() throws SQLException{
		Statement stmt = Conexao.getInstance().getConexao().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT s.* FROM state s JOIN city c on s.id=c.id_state GROUP BY s.id ORDER BY sum(c.population) DESC");
		List<Estado> list = new ArrayList<Estado>();
		
		while(rs.next()){
			Estado e = new Estado();
			
			e.setId(rs.getInt("id"));
			e.setNome(rs.getString("title"));
			e.setSigla(rs.getString("letter"));
			
			list.add(e);
		}
		
		return list;
	}

}
