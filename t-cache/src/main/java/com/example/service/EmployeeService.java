package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	public Employee getEmployee(String id) {
		try {
			log.info("Sleep for 5 sec ...");
			Thread.sleep(5*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Employee(id, "Emp"+id, "Tester");
	}
}
