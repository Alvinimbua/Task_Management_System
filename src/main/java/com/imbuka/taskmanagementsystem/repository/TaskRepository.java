package com.imbuka.taskmanagementsystem.repository;

import com.imbuka.taskmanagementsystem.entity.Task;
import com.imbuka.taskmanagementsystem.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByName (String name);

    List<Task> findAllByStatus(TaskStatus taskStatus);

}

