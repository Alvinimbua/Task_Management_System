package com.imbuka.taskmanagementsystem.service.impl;

import com.imbuka.taskmanagementsystem.dto.TaskDto;
import com.imbuka.taskmanagementsystem.entity.Task;
import com.imbuka.taskmanagementsystem.entity.TaskStatus;
import com.imbuka.taskmanagementsystem.exception.DuplicateTaskException;
import com.imbuka.taskmanagementsystem.exception.TaskNotFoundException;
import com.imbuka.taskmanagementsystem.mapper.TaskMapper;
import com.imbuka.taskmanagementsystem.repository.TaskRepository;
import com.imbuka.taskmanagementsystem.service.ITaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements ITaskService {

    private TaskRepository taskRepository;

    /**
     * @param taskDto - taskDtoObject
     */
    @Override
    public Task createTask(TaskDto taskDto) {
        //convert dto to entity
        Task task = TaskMapper.mapToTasks(taskDto, new Task());

        Optional<Task> duplicateTask = taskRepository.findByName(taskDto.getName());
        if (duplicateTask.isEmpty()) {
            return taskRepository.save(task);
        }

        log.info("Task with name = {} found in database", taskDto.getName());
        throw new DuplicateTaskException("Task with the same name already exists");
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepository.findAll());
    }

    @Override
    public Task getSingleTask(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + taskId + "not found"));
    }

    @Override
    public Task updateTaskStatus(Long taskId, TaskStatus newStatus) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task with ID " + taskId + "not found"));
        existingTask.setStatus(newStatus);
        existingTask.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(existingTask);
    }

    @Override
    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByStatus(taskStatus);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public boolean deleteById(Long taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            return true;
        } else {
            return false;
        }
    }

}
