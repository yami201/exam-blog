package com.example.examblog.repository;

import com.example.examblog.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map,Map.MapPk> {
}
