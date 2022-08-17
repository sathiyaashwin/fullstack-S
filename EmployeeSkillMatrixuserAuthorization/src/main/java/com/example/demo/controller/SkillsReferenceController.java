package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SkillsReference;
import com.example.demo.service.SkillReferenceService;


@RestController
@RequestMapping(path = "api/v1")
public class SkillsReferenceController {
	
	@Autowired
	private SkillReferenceService service;
	
	
		// insert skills By Manager
		@PostMapping(value = "/skills/approve")
		
		public Object skillValues(@RequestBody SkillsReference entity) {
			Object responceEntity = this.service.insert(entity);
			service.transactionstatus(entity, responceEntity);
			return responceEntity;
			}
		
		//Get All Skills
		@GetMapping(path = "/skills")
		public List<SkillsReference> getAll(){
			List<SkillsReference> list =this.service.skillList();
			service.transactionstatus(" ",list.size()+"Skill Meta Data Retrived From DB");
			return this.service.skillList();
		}

}
