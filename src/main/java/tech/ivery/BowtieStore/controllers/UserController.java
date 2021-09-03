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

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;
import tech.ivery.BowtieStore.services.UserServImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserServImpl uServ;
	
	@Autowired
	public UserController(UserServImpl u) {
		this.uServ = u;
	}
	
	@GetMapping("/all")
	public ResponseEntity<Set<User>> getAllUser(){
		return ResponseEntity.ok(uServ.getAllUser());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(uServ.getUserById(id));
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		try {
			return ResponseEntity.ok(uServ.addUser(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		uServ.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<User> deleteUser(@RequestBody User user){
		uServ.deleteUser(user);
		return ResponseEntity.ok(user);
	}
}
