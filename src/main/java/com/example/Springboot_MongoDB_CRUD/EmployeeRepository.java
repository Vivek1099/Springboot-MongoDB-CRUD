package com.example.Springboot_MongoDB_CRUD;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> 
{
	List<Employee> findByName(String name);
	
}
