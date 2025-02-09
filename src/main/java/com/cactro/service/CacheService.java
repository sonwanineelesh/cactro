package com.cactro.service;

import com.cactro.dto.CacheDTO;

public interface CacheService {

	String storeValues(CacheDTO dto);

	String getValueByKey(String key);

	String removeKey(String key);

	
	
}
