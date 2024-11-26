package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.IBrandHandler;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BrandController.class)

class BrandControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IBrandHandler iBrandHandler;

    @InjectMocks
    private BrandController brandController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveBrand() throws Exception {
        BrandRequestDto brandRequestDto = new BrandRequestDto();
        brandRequestDto.setBrandName("Test Dto");
        brandRequestDto.setBrandDescription("Second Test");
        GenericResponse genericResponse = GenericResponse.builder()
                .message("Brand Message")
                .date(LocalDateTime.now())
                .build();
        when(iBrandHandler.saveBrand(brandRequestDto)).thenReturn(genericResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        String brandRequestJson = objectMapper.writeValueAsString(brandRequestDto);
        mockMvc.perform(post("/api/brand/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(brandRequestJson)
        ).andExpect(status().isCreated());
    }
}
