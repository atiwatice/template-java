package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.CacheStore;
import com.example.entity.Employee;
import com.example.entity.Product;
import com.example.service.EmployeeService;
import com.example.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CacheController {

	@Autowired
	EmployeeService emp;

	@Autowired
	ProductService product;

	@Autowired
	CacheStore<Employee> empCache;

	@Autowired
	CacheStore<String> productCache;

	@GetMapping("/employee/{id}")
	public Employee searchEmployeeById(@PathVariable String id) {
		log.info("Search Employee id {}", id);

		Employee empCacheRecord = empCache.get(id);
		if (empCacheRecord != null) {
			log.info("Found employee in cache {}", empCacheRecord.getName());
			return empCacheRecord;
		}

		Employee empRecordFromDb = emp.getEmployee(id);
		empCache.add(id, empRecordFromDb);
		return empRecordFromDb;

	}
	@GetMapping("/product/{id}")
	public String searchProductById(@PathVariable String id) {
		
		log.info("Search product id {}",id);
		
		String productCacheRecord = productCache.get(id);
		
		if(productCacheRecord!=null) {
			log.info("Found product in cache {}", productCacheRecord);
			return productCacheRecord;
		}
		
		Product productRecordFromDb = product.getProduct(id);
		productCache.add(id, productRecordFromDb.getName());
		return productRecordFromDb.getName();
		
	}
}
