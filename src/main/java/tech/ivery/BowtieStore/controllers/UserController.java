package tech.ivery.BowtieStore.controllers;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpSession;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;
import tech.ivery.BowtieStore.services.UserServImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	private ObjectMapper om = new ObjectMapper();
	private UserServImpl uServ;
	
	@Autowired
	public UserController(UserServImpl u) {
		this.uServ = u;
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(HttpSession session, @RequestBody String jsonBody) throws UserNotFoundException{
		HashMap jb;
		try {
			jb = om.readValue(jsonBody, HashMap.class);
			User user = uServ.getUserByUsername(jb.get("username").toString());
			if(user != null) {
				if(user.getPassword().equals(jb.get("password").toString())) {
					session.setAttribute("username", user);
					return ResponseEntity.ok(user);
				}else {
					return ResponseEntity.status(301).build();
				}
			}else {
				return ResponseEntity.status(302).build();
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<User> checkLogin(HttpSession session){
		User loggedUser = (User) session.getAttribute("username");
		if(loggedUser != null) {
			return ResponseEntity.ok(loggedUser);
		}
		return ResponseEntity.badRequest().build();
	}
	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session){
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	@PostMapping
	public ResponseEntity<Void> registerUser(HttpSession session, @RequestBody User user){
		try {
			uServ.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateUser(HttpSession session, @RequestBody User user, @PathVariable("id") Integer id){
		User loggedUser = (User) session.getAttribute("username");
		if(loggedUser.getRole().getName().equals("admin")) {
			uServ.updateUser(user);
			return ResponseEntity.ok().build();
		}
		if(loggedUser != null && loggedUser.getId()==id) {
			uServ.updateUser(user);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
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
	
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Void> deleteUser(HttpSession session,@RequestBody User user, @PathVariable("id") Integer id){
		User loggedUser = (User) session.getAttribute("username");
		if(loggedUser.getRole().getName().equals("admin")) {
			uServ.deleteUser(user);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
