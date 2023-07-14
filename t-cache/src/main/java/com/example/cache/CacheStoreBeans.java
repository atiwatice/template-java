package com.example.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.entity.Employee;

@Configuration
public class CacheStoreBeans {

	@Bean
	public CacheStore<String> productNameCache() {
		return new CacheStore<String>(1, TimeUnit.HOURS);
	}

	@Bean
	public CacheStore<Employee> employeeCache() {
		return new CacheStore<Employee>(120, TimeUnit.SECONDS);
	}

}
