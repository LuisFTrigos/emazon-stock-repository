package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISupplyHandler;
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

@WebMvcTest(SupplyController.class)

class SupplyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ISupplyHandler supplyService;

    @InjectMocks
    private SupplyController supplyController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenAValidArgumentWhenSupplySavedSuccesfully() throws Exception {
        SupplyRequestDto supplyRequestDto = new SupplyRequestDto();
        supplyRequestDto.setSupplyName("Test Dto");
        supplyRequestDto.setSupplyDescription("Second Test");
        supplyRequestDto.setSupplyAmount(200L);
        supplyRequestDto.setSupplyPrice(100L);
        GenericResponse genericResponse = GenericResponse.builder()
                .message("Supply Message")
                .date(LocalDateTime.now())
                .build();
        when(supplyService.saveSupply(supplyRequestDto)).thenReturn(genericResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        String supplyRequestJson = objectMapper.writeValueAsString(supplyRequestDto);
        mockMvc.perform(post("/api/supply/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(supplyRequestJson)
        ).andExpect(status().isCreated());
    }

}
