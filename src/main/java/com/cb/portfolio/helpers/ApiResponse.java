package com.cb.portfolio.helpers;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;
}
