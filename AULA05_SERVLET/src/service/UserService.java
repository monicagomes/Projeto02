package service;

import dao.UserDAO;
import model.User;


public class UserService {
	UserDAO dao = new UserDAO();
	
	public int criar(User user) {
		return dao.criar(user);
	}
	
	public void atualizar(User user){
		dao.atualizar(user);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public User carregar(int id){
		return dao.carregar(id);
	}

}
