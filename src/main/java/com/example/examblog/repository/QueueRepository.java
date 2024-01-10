package com.example.examblog.repository;

import com.example.examblog.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue,Queue.QueuePk> {
}
