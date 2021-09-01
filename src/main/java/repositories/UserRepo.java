package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exceptions.UserNotFoundException;
import models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query(value="select * from user where id = :id", nativeQuery = true)
	public User getUserById(@Param("id") Integer id) throws UserNotFoundException;
}
