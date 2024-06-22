package com.example.Springboot_MongoDB_CRUD;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> 
{
	//List<Employee> findByname(String empname);
	
	@Query("from employee e where e.id=1?")
	Employee getById(int id);
}
