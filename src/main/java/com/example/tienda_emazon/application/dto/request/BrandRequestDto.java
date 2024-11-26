package com.example.tienda_emazon.application.dto.request;

import com.example.tienda_emazon.domain.util.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandRequestDto {

    @Min(value = 6, message = Constants.BRAND_MIN_NAME_SIZE)
    @Max(value = 50, message = Constants.BRAND_MAX_NAME_SIZE)
    @NotBlank(message = Constants.NOT_NULL_BRAND_NAME)
    private String brandName;
    @Min(value = 6, message = Constants.BRAND_MIN_DESCRIPTION_SIZE)
    @Max(value = 120, message = Constants.BRAND_MAX_DESCRIPTION_SIZE)
    @NotBlank(message = Constants.NOT_NULL_BRAND_DESCRIPTION)
    private String brandDescription;
}
