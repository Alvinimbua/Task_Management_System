package com.imbuka.taskmanagementsystem.controller;

import com.imbuka.taskmanagementsystem.dto.ResponseDTO;
import com.imbuka.taskmanagementsystem.dto.TaskDto;
import com.imbuka.taskmanagementsystem.entity.Task;
import com.imbuka.taskmanagementsystem.entity.TaskStatus;
import com.imbuka.taskmanagementsystem.service.ITaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.imbuka.taskmanagementsystem.constants.TasksConstants.*;

@RestController
@RequestMapping(path = "/api/v1/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(
        name = "Restful API for Task Management System at Smart Access Solutions",
        description = "A CRUD REST API for Smart To Create, Update , Get, Delete with Pending, Completed, Cancelled as status of the Tasks."
)
@Slf4j
public class TaskController {

    private ITaskService iTaskService;

    @Operation(
            summary = "Create Task Rest API",
            description = "Endpoint for creating Task"
    )
    @ApiResponse(
            responseCode = "1000",
            description = "HTTP Status Created"
    )
    @PostMapping("/createTask")
    public ResponseDTO createTask(@Valid @RequestBody TaskDto task) {
        //save to database
        Task newTask = iTaskService.createTask(task);
        ResponseDTO responseDTO = new ResponseDTO();
        if (newTask != null) {
            responseDTO.setCode(CREATE_TASKS_OK);
            responseDTO.setMessage("Task Created Successfully");
            responseDTO.setStatus("OK");
        } else {
            log.info("Task returned is NULL - Duplicate task found in the database");
            responseDTO.setCode(CREATE_TASKS_NOK);
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }

    /**
     * endpoint for getting all tasks
     *
     * @return - a list tasks
     */

    @Operation(
            summary = "Get all Task Rest API",
            description = "Endpoint for getting all Tasks"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Get"
    )
    @GetMapping("/getAllTasks")
    public ResponseDTO getAllTasks() {
        List<Task> tasks = iTaskService.getAllTasks();
        ResponseDTO responseDTO = new ResponseDTO();
        log.info("Tasks list size = {}", tasks.size());
        if (tasks.isEmpty()) {
            responseDTO.setCode(GET_ALL_TASKS_NOK);
            responseDTO.setMessage("No Tasks Found");
            responseDTO.setStatus("NOK");
            return responseDTO;
        }
        responseDTO.setCode(GET_ALL_TASKS_OK);
        responseDTO.setMessage("All Tasks Found");
        responseDTO.setStatus("OK");
        return responseDTO;
    }

    /**
     * Endpoint for viewing a single task
     *
     * @param id
     * @return - a single based on Id
     */

    @Operation(
            summary = "Get Single Task By Id Rest API",
            description = "Endpoint for getting single task by Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Task by Id retrieved Successfully"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Task by id not retrieved Successfully"
    )
    @GetMapping("/getSingleTaskById/{id}")
    public ResponseDTO getSingleTaskById(@PathVariable long id) {
        Task task = iTaskService.getSingleTask(id);
        ResponseDTO responseDTO = new ResponseDTO();
        if (task != null) {
            responseDTO.setCode(GET_SINGLE_TASKS_BY_ID_OK);
            responseDTO.setMessage("Task by Id retrieved Successfully");
            responseDTO.setStatus("OK");
        } else {
            log.info("Task with id = {}  not found", id);
            responseDTO.setCode(GET_SINGLE_TASKS_BY_ID_NOK);
            responseDTO.setMessage("Task by id not retrieved Successfully");
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }

    /**
     * Endpoint for updating the status of the task (Pending, Completed, Canceled)
     *
     * @param id
     * @param newStatus
     * @return - newly updated status based on id
     */

    @Operation(
            summary = "Updating Status of Task",
            description = "Endpoint for updating status of task(PENDING, CANCELED, COMPLETED)"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Task Status Updated Successfully"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Task status not updated Successfully"
    )
    @PutMapping("/{id}/status")
    public ResponseDTO updateTaskStatus(@PathVariable long id, @RequestParam TaskStatus newStatus) {
        Task updatedTask = iTaskService.updateTaskStatus(id, newStatus);
        ResponseDTO responseDTO = new ResponseDTO();
        if (updatedTask != null) {
            responseDTO.setCode(UPDATING_TASKS_STATUS_OK);
            responseDTO.setMessage("Task Status Updated Successfully");
            responseDTO.setStatus("OK");
        } else {
            log.info("Task with id = {} not found", id);
            responseDTO.setCode(UPDATING_TASKS_STATUS_NOK);
            responseDTO.setMessage("Task status not updated Successfully");
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }

    /**
     * Endpoint for getting the tasks via the status of the task (Pending, Completed,
     * Canceled)
     *
     * @param status
     * @return - tasks via status of tasks
     */

    @Operation(
            summary = "Get Tasks Via Status of Task",
            description = "Endpoint for getting task via  status of task(PENDING, CANCELED, COMPLETED)"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Task by status retrieved Successfully"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Task with status not retrieved Successfully"
    )
    @GetMapping("/getTaskStatus/{status}")
    public ResponseDTO getTasksByStatus(@PathVariable TaskStatus status) {
        List<Task> task = iTaskService.getTaskByStatus(status);
        ResponseDTO responseDTO = new ResponseDTO();
        if (task != null) {
            responseDTO.setCode(GET_TASKS_STATUS_OK);
            responseDTO.setMessage("Task by status retrieved Successfully");
            responseDTO.setStatus("OK");
        } else {
            log.info("Task with status = {} not found", status);
            responseDTO.setCode(GET_TASKS_STATUS_NOK);
            responseDTO.setMessage("Task with status not retrieved Successfully");
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }

    /**
     * Endpoint for deleting all the tasks.
     *
     * @return - deleted tasks
     */

    @Operation(
            summary = "Deleting all Tasks",
            description = "Endpoint for deleting all Tasks"
    )
    @ApiResponse(
            responseCode = "200",
            description = "All tasks deleted successfully"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Failed to delete Tasks"
    )
    @DeleteMapping("/deleteAllTasks")
    public ResponseDTO deleteAllTasks() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            iTaskService.deleteAllTasks();
            responseDTO.setCode(DELETING_TASKS_OK);
            responseDTO.setMessage("All tasks deleted successfully");
            responseDTO.setStatus("OK");
        } catch (Exception e) {
            responseDTO.setCode(DELETING_TASKS_NOK);
            responseDTO.setMessage("Failed to delete tasks: " + e.getMessage());
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }

    /**
     * Endpoint for deleting a task by id.
     *
     * @param id
     * @return - deleted task
     */

    @Operation(
            summary = "Deleting Task by Id",
            description = "Endpoint for deleting Task by Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Task deleted successfully"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Task not found or could not be deleted"
    )
    @DeleteMapping("/deleteTaskById/{id}")
    public ResponseDTO deleteTaskById(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (iTaskService.deleteById(id)) {
            responseDTO.setCode(DELETING_TASKS_BY_ID_OK);
            responseDTO.setMessage("Task deleted successfully");
            responseDTO.setStatus("OK");
        } else {
            responseDTO.setCode(DELETING_TASKS_BY_ID_NOK);
            responseDTO.setMessage("Task not found or could not be deleted");
            responseDTO.setStatus("NOK");
        }
        return responseDTO;
    }
}
