package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.SkillsReference;


public interface SkillReferenceRepository extends JpaRepository<SkillsReference, Integer> {
	@Query(value="select * from pavi_skill_reference_2022 where skill_name=:name", nativeQuery = true)
	public SkillsReference findBySkillName(@Param("name")String skillName);

}
