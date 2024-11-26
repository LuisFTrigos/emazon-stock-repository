package com.example.tienda_emazon.application.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericResponse {

    private String message;
    private LocalDateTime date;
}
