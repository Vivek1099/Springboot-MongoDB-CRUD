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
	
	@GetMapping("byname/{name}")
	List<Employee> Byname(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	
	@PostMapping("/update/{id}")
	public Employee update(@RequestBody Employee emp, @PathVariable int id)
	{
		Employee e=erepo.findById(id).get();
		e.setEmpage(emp.getEmpage());
		return erepo.save(e);
	}
	
}
