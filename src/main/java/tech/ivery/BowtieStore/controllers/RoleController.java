package tech.ivery.BowtieStore.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.ivery.BowtieStore.exceptions.RoleNotFoundException;
import tech.ivery.BowtieStore.models.Role;
import tech.ivery.BowtieStore.services.RoleServImpl;

@RestController
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
	@PostMapping("/add-role")
	public ResponseEntity<Role> addRole(@RequestBody Role role){
		try {
			return ResponseEntity.ok(rServ.addRole(role));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@PutMapping
	public ResponseEntity<Role> updateRole(@RequestBody Role role){
		rServ.updateRole(role);
		return ResponseEntity.ok(role);
	}
	@DeleteMapping
	public ResponseEntity<Role> deleteRole(@RequestBody Role role){
		rServ.deleteRole(role);
		return ResponseEntity.ok(role);
	}
}
