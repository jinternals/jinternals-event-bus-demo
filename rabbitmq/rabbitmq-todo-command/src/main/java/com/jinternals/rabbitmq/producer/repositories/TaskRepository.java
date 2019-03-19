package com.jinternals.rabbitmq.producer.repositories;

import com.jinternals.rabbitmq.producer.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
}
