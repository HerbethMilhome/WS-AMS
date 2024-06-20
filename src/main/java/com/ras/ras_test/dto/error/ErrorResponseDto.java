package com.ras.ras_test.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String messages;
    private Integer statusCode;
}
