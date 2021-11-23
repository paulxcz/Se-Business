package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Role;

public interface IRoleService {
	public void insert(Role role);

	List<Role> list();

}
