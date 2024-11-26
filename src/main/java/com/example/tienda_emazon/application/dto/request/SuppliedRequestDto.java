package com.example.tienda_emazon.application.dto.request;


import com.example.tienda_emazon.domain.util.Constants;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuppliedRequestDto {

    @NotBlank(message = Constants.NOT_NULL_SUPPLY_NAME)
    private String suppliedName;
    @NotBlank(message = Constants.NOT_NULL_SUPPLY_NAME)
    private int suppliedAmount;
}
