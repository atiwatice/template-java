package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	public Product getProduct(String id) {
		try {
			log.info("Sleep for 5 secs ...");
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Product(id,"Product"+id, "$10.00");

	}

}
