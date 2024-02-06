package com.imbuka.taskmanagementsystem.service;

import com.imbuka.taskmanagementsystem.dto.TaskDto;
import com.imbuka.taskmanagementsystem.entity.Task;
import com.imbuka.taskmanagementsystem.entity.TaskStatus;

import java.util.List;

public interface ITaskService {

    /**
     * method for creating the task
     */
    Task createTask(TaskDto taskDto);

    /**
     * method for viewing all the task
     */
    List<Task> getAllTasks();

    /**
     * method for viewing a single task
     */
    Task getSingleTask(Long taskId);

    /**
     * method for updating the status of the task (Pending, Completed, Canceled)
     */
    Task updateTaskStatus(Long taskId, TaskStatus newStatus);

    /**
     * method for getting the tasks via the status of the task (Pending, Completed,
     * Canceled)
     */
    List<Task> getTaskByStatus(TaskStatus taskStatus);

    /**
     * method for deleting all task
     */
    void deleteAllTasks();

    /**
     * method for deleting the task by id
     *
     * @return
     */
    boolean deleteById(Long taskId);

}
