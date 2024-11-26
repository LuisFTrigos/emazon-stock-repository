package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ICategoryHandler;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)

class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ICategoryHandler categoryService;

    @InjectMocks
    private CategoryController categoryController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCategory() throws Exception {
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setCategoryName("Test Dto");
        categoryRequestDto.setCategoryDescription("Second Test");
        GenericResponse genericResponse = GenericResponse.builder()
                .message("Category Message")
                .date(LocalDateTime.now())
                .build();
        when(categoryService.saveCategory(categoryRequestDto)).thenReturn(genericResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        String categoryRequestJson = objectMapper.writeValueAsString(categoryRequestDto);
        mockMvc.perform(post("/api/category/create")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryRequestJson)
                ).andExpect(status().isCreated());
    }

    @Test
    void getAllCategoriesList() throws Exception {
        CustomPage<CategoryModel> categoryTestList = new CustomPage<>();
        when(categoryService.getCategoriesPaginated(any(PageRequestDomain.class))).thenReturn(categoryTestList);
        mockMvc.perform(get("/api/category"))
                .andExpect(status().isOk());
    }
}