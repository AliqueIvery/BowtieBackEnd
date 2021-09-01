package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import exceptions.UserNotFoundException;
import models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User getUserById(Integer id) throws UserNotFoundException;
}
