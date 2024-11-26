package com.example.tienda_emazon.application.dto.request;

import com.example.tienda_emazon.domain.util.Constants;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SupplyRequestDto {

    @Min(value = 2, message = Constants.SUPPLY_MIN_NAME_SIZE)
    @Max(value = 50, message = Constants.SUPPLY_MAX_NAME_SIZE)
    @NotBlank(message = Constants.NOT_NULL_SUPPLY_NAME)
    private String supplyName;

    @Min(value = 5, message = Constants.SUPPLY_MIN_DESCRIPTION_SIZE)
    @Max(value = 100, message = Constants.SUPPLY_MAX_DESCRIPTION_SIZE)
    @NotBlank(message = Constants.NOT_NULL_SUPPLY_DESCRIPTION)
    private String supplyDescription;

    @NotBlank(message = Constants.NOT_EMPTY_SUPPLY_AMOUNT)
    private long supplyAmount;

    @NotBlank(message = Constants.NOT_EMPTY_SUPPLY_PRICE)
    private long supplyPrice;

    private List<String> associatedCategories;
}
