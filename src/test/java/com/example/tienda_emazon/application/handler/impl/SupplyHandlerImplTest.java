package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.SupplyDtoMapper;
import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.exception.InvalidArgumentException;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplyHandlerImplTest {

    private List<SupplyModel> listArticles;
    private List<SupplyRequestDto> listArticlesDTO;

    @Mock
    private SupplyDtoMapper supplyDtoMapper;
    @Mock
    private ISupplyServicePort iSupplyServicePort;
    @InjectMocks
    private SupplyHandlerImpl toTest;


    @Test
    void veifyTheServiceReturnsCorrectResultWhenSaveSupply() {
        SupplyRequestDto supplyRequestDto = new SupplyRequestDto();

        SupplyModel testSupplyModel = new SupplyModel();
        testSupplyModel.setSupplyDescription(null);

        when(supplyDtoMapper.dtoToModel(supplyRequestDto))
                .thenReturn(testSupplyModel);

        assertThrows(InvalidArgumentException.class, () ->
                toTest.saveSupply(supplyRequestDto));
        verify(iSupplyServicePort, never()).createSupply(any());
    }

    @Test
    void givenDateWhenSupplySavedSuccessfully() {
        SupplyRequestDto supplyRequestDto = new SupplyRequestDto();

        SupplyModel testSupplyModel = new SupplyModel();
        testSupplyModel.setSupplyDescription("Description Text");

        when(supplyDtoMapper.dtoToModel(supplyRequestDto))
                .thenReturn(testSupplyModel);
        GenericResponse genericResponse = toTest.saveSupply(supplyRequestDto);
        assertNotNull(genericResponse);
        assertEquals(Constants.SUPPLY_CREATED_SUCCESSFULLY,
                genericResponse.getMessage());
        assertNotNull(genericResponse.getDate());
    }

    @Test
    public void obtainAListOfAllTheSuppliesWhenSavedSuccesfully() {
        MockitoAnnotations.openMocks(this);

        SupplyModel article1 = new SupplyModel();
        article1.setId(1L);
        article1.setSupplyName("Articulo 1");
        article1.setSupplyPrice(100L);

        SupplyModel article2 = new SupplyModel();
        article2.setId(2L);
        article2.setSupplyName("Articulo 2");
        article2.setSupplyPrice(200L);

        listArticles = Arrays.asList(article1, article2);

        SupplyRequestDto articleDTO1 = new SupplyRequestDto();
        articleDTO1.setSupplyName("Articulo 1");
        articleDTO1.setSupplyPrice(100L);

        SupplyRequestDto articleDTO2 = new SupplyRequestDto();
        articleDTO2.setSupplyName("Articulo 2");
        articleDTO2.setSupplyPrice(200L);

        listArticlesDTO = Arrays.asList(articleDTO1, articleDTO2);
}
   /* @Test
    public void testObtainPaginatedSupplies(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<SupplyModel> supplyModelPage = new PageImpl<>
                (listArticles, pageable, listArticles.size());

        when(iSupplyServicePort.pageSupply(pageable)).thenReturn(supplyModelPage);
        when(supplyDtoMapper.modelToDto(listArticles.get(0))).thenReturn(listArticlesDTO.get(0));
        when(supplyDtoMapper.modelToDto(listArticles.get(1))).thenReturn(listArticlesDTO.get(1));

        Page<SupplyModel> result = iSupplyServicePort.pageSupply(pageable);

        assertEquals(2, result.getTotalElements());
        assertEquals("Articulo 1", result.getContent().get(0).getBrandName());
        assertEquals("Articulo 2", result.getContent().get(1).getBrandName());

        verify(iSupplyServicePort, times(1)).pageSupply(pageable);
        verify(supplyDtoMapper, times(1)).modelToDto(listArticles.get(0));
        verify(supplyDtoMapper, times(1)).modelToDto(listArticles.get(1));
    }*/

}
