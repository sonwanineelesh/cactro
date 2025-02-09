package com.cactro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cactro.entity.Cache;

@Repository
public interface CacheRepository extends JpaRepository<Cache, String> {

}
