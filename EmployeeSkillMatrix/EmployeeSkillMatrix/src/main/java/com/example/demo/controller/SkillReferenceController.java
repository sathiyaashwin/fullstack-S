package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Skills_Reference;
import com.example.demo.entity.Transaction_Log;
import com.example.demo.repo.TransactionRepo;
import com.example.demo.services.Skill_Reference_Service;

@RestController
@RequestMapping(path = "api/v1")
public class SkillReferenceController {

	
	

	@Autowired
	private Skill_Reference_Service service;
	
	
		/*POST API to  insert skills By Manager*/
		@PostMapping(value = "/skills")
		
		public Object skillValues(@RequestBody Skills_Reference entity) {
			Object responceEntity = this.service.insert(entity);
			service.transactionstatus(entity, responceEntity);
			return responceEntity;
			
		}
		
		@GetMapping(path = "/skills")
		public List<Skills_Reference> getAll(){
			List<Skills_Reference> list =this.service.skillList();
			service.transactionstatus(" ",list.size()+"Skill Meta Data Retrived From DB");
			return this.service.skillList();
		}
		
	
}
