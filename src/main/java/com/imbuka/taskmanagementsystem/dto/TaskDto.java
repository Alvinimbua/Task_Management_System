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
            example = "Alvin Imbuka"
    )
    private String name;

    @NotEmpty(message = "Description cannot be empty or null")
    @Schema(
            description = "Creation of Task Management System",
            example = "End point for creating CRUD Operations"
    )
    private String description;

    private TaskStatus status;
}
