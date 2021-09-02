package tech.ivery.BowtieStore.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ivery.BowtieStore.exceptions.RoleNotFoundException;
import tech.ivery.BowtieStore.models.Role;
import tech.ivery.BowtieStore.repositories.RoleRepo;

@Service
public class RoleServImpl implements RoleService {
	private RoleRepo rRepo;
	
	@Autowired
	public RoleServImpl(RoleRepo r) {
		this.rRepo = r;
	}
	
	@Override
	public Role addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return rRepo.save(role);
	}

	@Override
	public Role getRoleById(Integer id) throws RoleNotFoundException {
		// TODO Auto-generated method stub
		return rRepo.getRoleById(id);
	}

	@Override
	public Set<Role> getAllRole() {
		// TODO Auto-generated method stub
		List<Role> list = rRepo.findAll();
		Set<Role> set = new HashSet<>();
		set.addAll(list);
		return set;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		try {
			if(getRoleById(role.getId()) != null) {
				rRepo.save(role);
			}
		} catch (RoleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		try {
			if(getRoleById(role.getId()) != null) {
				rRepo.delete(role);
			}
		} catch (RoleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
