package com.example.tienda_emazon.application.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuppliedResponse {

    private Long suppliedId;

    private String suppliedName;

    private int suppliedAmount;

}
