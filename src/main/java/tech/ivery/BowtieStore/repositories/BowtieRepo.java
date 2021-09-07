package tech.ivery.BowtieStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.ivery.BowtieStore.models.Bowtie;

public interface BowtieRepo extends JpaRepository<Bowtie, Integer> {
	@Query(value="select * from bowtie where id=:id", nativeQuery=true)
	public Bowtie getBowtieById(@Param("id") Integer id) throws Exception;
}
