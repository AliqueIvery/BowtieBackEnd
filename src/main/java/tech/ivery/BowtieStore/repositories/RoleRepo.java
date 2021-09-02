package tech.ivery.BowtieStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.ivery.BowtieStore.exceptions.RoleNotFoundException;
import tech.ivery.BowtieStore.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	@Query(value="select * from role where id = :id", nativeQuery=true)
	public Role getRoleById(@Param("id") Integer id) throws RoleNotFoundException;
}
