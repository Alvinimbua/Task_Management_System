package com.imbuka.taskmanagementsystem.mapper;

import com.imbuka.taskmanagementsystem.dto.TaskDto;
import com.imbuka.taskmanagementsystem.entity.Task;

/**
 * A class that changes Task Entity to TaskDto and vice versa
 */
public class TaskMapper {

    /**
     * It is going to map all data from TaskEntity to TaskDto
     *
     * @param task
     * @param taskDto
     * @return
     */

    public static TaskDto mapToTasksDto(Task task, TaskDto taskDto) {
        taskDto.setDescription(task.getDescription());
        taskDto.setName(task.getName());
        taskDto.setStatus(task.getStatus());

        return taskDto;
    }

    /**
     * It is going to map all data from TaskEntity to TaskDto
     *
     * @param task
     * @param taskDto
     * @return
     */

    public static Task mapToTasks(TaskDto taskDto, Task task) {
        task.setDescription(taskDto.getDescription());
        task.setName(taskDto.getName());
        task.setStatus(taskDto.getStatus());

        return task;
    }

}
