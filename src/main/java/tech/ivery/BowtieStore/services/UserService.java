package tech.ivery.BowtieStore.services;

import java.util.Set;

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;

public interface UserService {
	public User addUser(User user) throws Exception;
	public User getUserById(Integer id) throws UserNotFoundException;
	public Set<User> getAllUser();
	public void updateUser(User user);
	public void deleteUser(User user);
}
