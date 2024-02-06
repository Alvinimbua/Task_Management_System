package com.imbuka.taskmanagementsystem.dto;

import com.imbuka.taskmanagementsystem.entity.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(
        name = "Tasks",
        description = " Schema to hold Task Information"
)
public class TaskDto {
    @NotEmpty(message = "Name cannot be empty or null")
    @Schema(
            description = "Task name",
            example = "Creation of Task Management DashBoard"
    )
    private String name;

    @NotEmpty(message = "Description cannot be empty or null")
    @Schema(
            description = "Task Description",
            example = "End point for creating CRUD Operations"
    )
    private String description;


    @NotEmpty(message = "Task Status cannot be empty or null")
    @Schema(
            description = "Task Status",
            example = "PENDING, COMPLETED, CANCELED"
    )
    private TaskStatus status;
}
