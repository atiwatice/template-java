package com.example.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheStore<T> {
	private Cache<String, T> cache;

	// Constructor to build cache store
	public CacheStore(int expiryDuration, TimeUnit timeUnit) {
		cache = CacheBuilder.newBuilder().expireAfterWrite(expiryDuration, timeUnit)
				.concurrencyLevel(Runtime.getRuntime().availableProcessors()).build();
	}

	// Method to fetch previous stored record using record key
	public T get(String key) {
		return cache.getIfPresent(key);
	}

	// Method to put a new record in cache store with record key
	public void add(String key, T value) {
		if (key != null && value != null) {
			cache.put(key, value);
			log.info("Record stored in {} Cache with key {}", value.getClass().getSimpleName(), key);
		}
	}

}
