package com.imbuka.taskmanagementsystem;

import com.imbuka.taskmanagementsystem.entity.Task;
import com.imbuka.taskmanagementsystem.entity.TaskStatus;
import com.imbuka.taskmanagementsystem.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TaskManagementSystemApplicationTests {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setName("Coding");
        task.setDescription("Developing of the back end");
        task.setStatus(TaskStatus.valueOf("PENDING"));
        taskRepository.save(task);

    }

    @Test
    public void testGetTaskById() {
        Optional<Task> task = taskRepository.findById(1L);
        System.out.println("The task  is " + task );
    }




}
