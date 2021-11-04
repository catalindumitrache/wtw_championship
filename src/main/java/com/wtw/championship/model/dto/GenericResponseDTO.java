package com.wtw.championship.model.dto;

import lombok.Data;

@Data
public class GenericResponseDTO {

    private int code;
    private String message;

    public GenericResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
