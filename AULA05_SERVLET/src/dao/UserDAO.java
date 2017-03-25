package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	public int criar(User user) {
		String sqlInsert = "INSERT INTO tbusuario(idusuario,matricula,nome,cpf,"+
                            "rg,endereco,telefone,email,funcao,conjunto)"+
                            "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setInt(1, user.getId());
			stm.setString(2, user.getPlate());
			stm.setString(3, user.getName());
			stm.setString(4, user.getCpf());
			stm.setString(5, user.getRg());
			stm.setString(6, user.getAddress());
			stm.setString(7, user.getPhone());
			stm.setString(8, user.getEmail());
			stm.setString(9, user.getFunction());
			stm.setString(10, user.getGroup());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					user.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user.getId();
	}

	public void atualizar(User user) {
		String sqlUpdate = "UPDATE TBUSUARIO SET matricula=?, nome=?, cpf=?, rg=?,  endereco=?, telefone=?, email=?, funcao=?, conjunto=? WHERE idusuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, user.getPlate());
			stm.setString(2, user.getName());
			stm.setString(3, user.getRg());
			stm.setString(4, user.getCpf());
			stm.setString(5, user.getAddress());
			stm.setString(6, user.getPhone());
			stm.setString(7, user.getEmail());
			stm.setString(8, user.getFunction());
			stm.setString(9, user.getGroup());
			stm.setInt(10, user.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM TBUSUARIO WHERE idusuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User carregar(int id) {
		User user = new User();
		user.setId(id);
		String sqlSelect = "SELECT *  FROM TBUSUARIO WHERE idusuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, user.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					user.setPlate(rs.getString("matricula"));
					user.setName(rs.getString("nome"));
					user.setRg(rs.getString("rg"));
					user.setCpf(rs.getString("cpf"));
					user.setAddress(rs.getString("endereco"));
					user.setPhone(rs.getString("telefone"));
					user.setEmail(rs.getString("email"));
					user.setFunction(rs.getString("funcao"));					
					user.setGroup(rs.getString("conjunto"));
				} else {
					user.setId(-1);
					user.setPlate(null);
					user.setName(null);
					user.setRg(null);
					user.setCpf(null);
					user.setAddress(null);
					user.setPhone(null);
					user.setEmail(null);
					user.setFunction(null);
					user.setGroup(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return user;
	}

}
