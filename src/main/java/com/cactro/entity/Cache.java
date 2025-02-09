package com.cactro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cache")
public class Cache {
	@Id
	@Column(name = "cache_key", unique = true, nullable = false)
	private String key;

	private String value;

	public Cache() {
		// TODO Auto-generated constructor stub
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Cache(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
