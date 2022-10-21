package com.abhisheksah.controller;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Department;
import com.abhisheksah.services.Departmentservice;
import com.abhisheksah.services.DepartmentserviceImpl;



// Class Work as a Controller.  

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/department")
public class DepartmentController {
	
	
	
	@Autowired //Autowire the DepartmentService class  
	private DepartmentserviceImpl service;

	@GetMapping("/hello")
	public String test() {
		return "Hello I am From Department MicroService";
	}
	
	//creating post mapping that post the department detail in the database  
	@PostMapping("/adddepartment")
	public Department addDept(@RequestBody Department dept) {
		return this.service.addDepartment(dept);
	}
	
	//creating a get mapping that retrieves all the department detail from the database   
	@GetMapping("/alldepartment")
	public List<Department> getDepartment(){
	return service.getAlldept();
	
	}
	
	//creating a get mapping that retrieves the detail of a specific department
	@GetMapping("/get/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") long id){
		
		return this.service.getDepartment(id);
	}
	
	//creating put mapping that updates the department detail   
//	@PutMapping("/update/{id}")
//	public Department updateDepartment(@RequestBody Department dept){
//		return this.service.updateDepartment(dept);
//	}
	
	
	
	@PutMapping("/update/{id}")
	public void updateDepartment(@RequestBody Department dept, @PathVariable long id) {
	
     service.updateDepartment(dept,id);
	}
	
	//creating a delete mapping that deletes a specified department
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") long id) 
	{
		return this.service.deleteDepartment(id);
	}
	
	

}
