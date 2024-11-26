package com.example.tienda_emazon.application.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse {

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

}
