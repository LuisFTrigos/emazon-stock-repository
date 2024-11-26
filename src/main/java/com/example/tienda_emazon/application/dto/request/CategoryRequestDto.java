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
public class CategoryRequestDto {

    @Min(value = 6, message = Constants.CATEGORY_MIN_NAME_SIZE)
    @Max(value = 50, message = Constants.CATEGORY_MAX_NAME_SIZE)
    @NotBlank(message = Constants.NOT_NULL_CATEGORY_NAME)
    private String categoryName;
    @Min(value = 6, message = Constants.CATEGORY_MIN_DESCRIPTION_SIZE)
    @Max(value = 90, message = Constants.CATEGORY_MAX_DESCRIPTION_SIZE)
    @NotBlank(message = Constants.NOT_NULL_CATEGORY_DESCRIPTION)
    private String categoryDescription;
}
