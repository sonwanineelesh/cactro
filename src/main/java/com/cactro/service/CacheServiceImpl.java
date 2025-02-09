package com.cactro.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cactro.dto.CacheDTO;
import com.cactro.entity.Cache;
import com.cactro.repository.CacheRepository;

import jakarta.transaction.Transactional;

@Transactional
@Validated
@Service
public class CacheServiceImpl implements CacheService {
	private static final int MAX_SIZE = 100; // It is a predefined max_size as mentioned in Question
	private Map<String, String> cache;

	public CacheServiceImpl() {
		this.cache = new LinkedHashMap<>(MAX_SIZE, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
				return size() > MAX_SIZE;
			}
		};
	}

	@Autowired
	private CacheRepository cacheRepository;

	@Override
	public String storeValues(CacheDTO dto) {
		if (cacheRepository.findById(dto.getKey()).isPresent()) {
			return "This item is already present, please try storing other item";
		}

		if (cacheRepository.count() >= MAX_SIZE) {
			return "This is the max limit, you can not store more items";
		}
		cacheRepository.save(new Cache(dto.getKey(), dto.getValue()));
		cache.put(dto.getKey(), dto.getValue());
		return "Stored successfully";
	}

	@Override
	public String getValueByKey(String key) {
		// TODO Auto-generated method stub
		var pair = cacheRepository.findById(key);
		if (pair.isPresent()) {
			return pair.get().getValue();
		}
		return "No value found";
	}

	@Override
	public String removeKey(String key) {
		// TODO Auto-generated method stub
		var pair = cacheRepository.findById(key);
		if (pair.isPresent()) {
			cacheRepository.delete(pair.get());
		}
		return "Cache has been deleted";
	}
}
