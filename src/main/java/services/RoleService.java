package services;

import java.util.Set;

import exceptions.RoleNotFoundException;
import models.Role;

public interface RoleService {
	public Role addRole(Role role) throws Exception;
	public Role getRoleById(Integer id) throws RoleNotFoundException;
	public Set<Role> getAllROle();
	public void updateRole(Role role);
	public void deleteRole(Role role);	
}
