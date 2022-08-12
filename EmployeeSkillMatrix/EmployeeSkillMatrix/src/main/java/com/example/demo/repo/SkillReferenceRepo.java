package com.example.demo.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Skills_Reference;

public interface SkillReferenceRepo extends JpaRepository<Skills_Reference, Integer> {

	@Query(value="select * from skills_reference_vnk where skill_name=:name", nativeQuery = true)
	public Skills_Reference findByName(@Param("name")String skillName);
}
