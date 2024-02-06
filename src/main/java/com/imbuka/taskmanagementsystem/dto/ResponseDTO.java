package com.imbuka.taskmanagementsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A simple DTO to handle responses.
 */


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Responses",
        description = " Schema to hold Responses"
)
public class ResponseDTO {
    @NotEmpty(message = "Code cannot be empty or null")
    @Schema(
            description = "CREATE_TASK_OK",
            example = "1000"
    )
    private int code;

    @NotEmpty(message = "Message cannot be empty or null")
    @Schema(
            description = "Message to show as Response",
            example = "Task Created Successfully"
    )
    private String message;

    @NotEmpty(message = "Status cannot be empty or null")
    @Schema(
            description = "Status response of the Task ",
            example = "OK || NOK"
    )
    private String status;

}
