package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Users;

public interface IUserService {
	public Integer insert(Users user);

	List<Users> list();

}
