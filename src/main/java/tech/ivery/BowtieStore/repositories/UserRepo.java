package tech.ivery.BowtieStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query(value="select * from user where id = :id", nativeQuery = true)
	public User getUserById(@Param("id") Integer id) throws UserNotFoundException;
	@Query(value="select * from user where username = :username", nativeQuery=true)
	public User getUserByUsername(@Param("username") String username) throws UserNotFoundException;
}
