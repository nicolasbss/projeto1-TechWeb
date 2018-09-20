package br.edu.insper.techweb.projeto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/projeto1?useTimezone=true&serverTimezone=UTC", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNota(int id) {
		String conteudo = "erro1";
		
		PreparedStatement stmt;
		ResultSet rs;
		String sql = "SELECT * FROM Notas WHERE id=?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				conteudo = rs.getString("conteudo");
				System.out.println("teste:");
				System.out.println(conteudo);
				return (rs.getString("conteudo"));
			}else {
				return "erro";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conteudo;	
	}
	
	public List<Notas> getListaNotas(int id) {
		
		List<Notas> notas = new ArrayList<Notas>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM Notas WHERE pessoa_id=?;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Notas nota = new Notas();				
				nota.setId(rs.getInt("id"));
				nota.setTipo(rs.getString("tipo"));
				nota.setConteudo(rs.getString("conteudo"));
				nota.setPessoa_id(rs.getInt("pessoa_id"));				
				notas.add(nota);
			}
		} catch (SQLException e) {
			System.out.println("asjhias");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return notas;
	}
	
	public List<Notas> getListaNotasOrdenadas(int id) {
		
		List <Notas> notas = new ArrayList<Notas>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM Notas WHERE pessoa_id=? ORDER BY data_atualizada DESC;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Notas nota = new Notas();				
				nota.setId(rs.getInt("id"));
				nota.setTipo(rs.getString("tipo"));
				nota.setConteudo(rs.getString("conteudo"));
				nota.setPessoa_id(rs.getInt("pessoa_id"));				
				notas.add(nota);
			}
		} catch (SQLException e) {
			System.out.println("asjhias");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return notas;
	}
	
	public void adicionaNota(Notas nota) {
		String sql = "INSERT INTO Notas" + "(tipo, data, conteudo, pessoa_id) values(?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,nota.getTipo());
			stmt.setString(2, nota.getDateTime());
			stmt.setString(3,nota.getConteudo());
			stmt.setInt(4, nota.getPessoa_id());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void adicionaPessoa(Pessoas pessoa) {
		String sql = "INSERT INTO Pessoa" + "(login, senha) values(?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,pessoa.getLogin());
			stmt.setString(2, pessoa.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alteraNota(Notas nota) {
		String sql = "UPDATE Notas SET " +
				 "tipo=?, conteudo=?, data_atualizada=? WHERE id=?";
				PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getTipo());
			stmt.setString(2, nota.getConteudo());
			stmt.setString(3, nota.getDataAtualizada());
			stmt.setInt(4, nota.getId());			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alteraPessoa(Pessoas pessoa) {
		String sql = "UPDATE Pessoa SET " +
		 "login=?, senha=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getLogin());
			stmt.setString(2, pessoa.getSenha());
			stmt.setInt(3, pessoa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeNota(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM Notas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removePessoa(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM Pessoa WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int autenticaUsuario(Pessoas pessoa) {
		PreparedStatement stmt;
		String sql = "SELECT * FROM Pessoa WHERE login=?";
		ResultSet rs;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getLogin());
			rs = stmt.executeQuery();
			if (rs.next()) {
				if(pessoa.getSenha().equals(rs.getString("senha"))) {
					return rs.getInt("id");
				} else {
					return 0;
				}
			}else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 0;
	}
	public String horarioCriacao(Notas nota) {
		PreparedStatement stmt;
		String sql = "SELECT * FROM notas WHERE id=?";
		ResultSet rs;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, nota.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("data");
			}
			else {
				return "none";
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return "none";
	}
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
