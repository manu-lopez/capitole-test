package com.manu.inditex.capitole_test.price.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String error;
    private String msg;
}
