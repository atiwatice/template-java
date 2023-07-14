package com.example;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Compare {
	public static void main(String[] args) {
		LocalDateTime nowDatetime = LocalDateTime.now();
		LocalDateTime pastDate = LocalDateTime.parse("2023-01-14T15:20:56.000");

		Boolean isBefore = nowDatetime.isBefore(pastDate);
		log.info("Date time now =>{}, Date time to compare =>{} is before {}", nowDatetime, pastDate, isBefore);
		
		Boolean isAfter = nowDatetime.isAfter(pastDate);
		log.info("Date time now =>{}, Date time to compare =>{} is after {}", nowDatetime, pastDate, isAfter);
		
		
		Boolean isEqual = nowDatetime.isEqual(pastDate);
		log.info("Date time now =>{}, Date time to compare =>{} is equal {}", nowDatetime, pastDate, isEqual);
		

	}
}
