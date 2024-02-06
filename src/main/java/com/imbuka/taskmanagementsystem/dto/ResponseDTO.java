package com.imbuka.taskmanagementsystem.dto;

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
public class ResponseDTO {
    private int code;
    private String message;
    private String status;

}
