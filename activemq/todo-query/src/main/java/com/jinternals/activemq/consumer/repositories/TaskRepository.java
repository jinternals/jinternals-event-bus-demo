package com.jinternals.activemq.consumer.repositories;

import com.jinternals.activemq.consumer.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
}
