package com.cactro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cactro.dto.CacheDTO;
import com.cactro.service.CacheService;

@RestController
//@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private CacheService cacheService;

	public CacheController(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@PostMapping("/cache")
	public ResponseEntity<String> store(@RequestBody CacheDTO dto) {
		return ResponseEntity.ok(cacheService.storeValues(dto));
	}

	@GetMapping("/cache/{key}")
	public ResponseEntity<String> retrieve(@PathVariable String key) {
		String value = cacheService.getValueByKey(key);
		return value != null ? ResponseEntity.ok(value) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/cache/{key}")
	public ResponseEntity<String> remove(@PathVariable String key) {
		return cacheService.removeKey(key) != null ? ResponseEntity.ok("Removed successfully")
				: ResponseEntity.notFound().build();
	}
}
