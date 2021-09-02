package controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import exceptions.RoleNotFoundException;
import models.Role;
import services.RoleServImpl;

@Controller
@RequestMapping("/role")
public class RoleController {
	private RoleServImpl rServ;
	@Autowired
	public RoleController(RoleServImpl r) {
		this.rServ = r;
	}
	
	@GetMapping("/all")
	public ResponseEntity<Set<Role>> getAllRoles(){
		return ResponseEntity.ok(rServ.getAllRole());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(rServ.getRoleById(id));
		} catch (RoleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
