package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
