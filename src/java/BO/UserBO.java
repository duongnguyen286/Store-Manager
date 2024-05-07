package BO;

import java.sql.SQLException;

import Model.Bean.User;
import DAO.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public User getAccount(String email, String password) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		return userDAO.getUser(email, password);
	}
}
