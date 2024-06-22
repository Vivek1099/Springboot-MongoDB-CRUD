package com.example.Springboot_MongoDB_CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@Autowired 
	EmployeeRepository erepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "This is a crud test with mongodb";
	}
	
	@PostMapping("/save")
	public String saveall(@RequestBody Employee emp)
	{
		erepo.save(emp);
		return "data saved";
	}
	
	@GetMapping("/show")
	public List<Employee> showall()
	{
		return erepo.findAll();
	}
	
	@GetMapping("byid/{empid}")
	public Optional<Employee> ById(@PathVariable int empid)
	{
		return erepo.findById(empid);
	}
	
	@DeleteMapping("delbyid/{empid}")
	public String DelById(@PathVariable int empid)
	{
		erepo.deleteById(empid);
		return "Data deleted";
	}
	
//	@GetMapping("byname/{empname}")
//	List<Employee> Byname(@PathVariable String empname)
//	{
//		return erepo.findByname(empname);
//	}
//	
	@GetMapping("getid/{empid}")
	Employee getId(@PathVariable int empid)
	{
		return erepo.getById(empid);
	}
}
