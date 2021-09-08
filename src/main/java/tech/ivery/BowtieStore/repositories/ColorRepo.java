package tech.ivery.BowtieStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.ivery.BowtieStore.models.Color;

public interface ColorRepo extends JpaRepository<Color, Integer> {
	@Query(value="select * from Color where id= :id", nativeQuery=true)
	public Color getColorById(@Param("id")Integer id) throws Exception;
}
