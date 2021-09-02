package tech.ivery.BowtieStore.services;

import java.util.Set;

import tech.ivery.BowtieStore.exceptions.RoleNotFoundException;
import tech.ivery.BowtieStore.models.Role;

public interface RoleService {
	public Role addRole(Role role) throws Exception;
	public Role getRoleById(Integer id) throws RoleNotFoundException;
	public Set<Role> getAllRole();
	public void updateRole(Role role);
	public void deleteRole(Role role);	
}
