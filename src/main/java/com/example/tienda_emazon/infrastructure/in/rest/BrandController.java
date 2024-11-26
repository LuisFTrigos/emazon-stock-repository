package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.IBrandHandler;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static com.example.tienda_emazon.domain.util.Constants.ADMIN_ROLE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "jwt")
public class BrandController {
    private final IBrandHandler brandHandler;


    @Secured({ADMIN_ROLE})
    @Operation(summary = "Add a new brand",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Brand created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "403", description = "The user must be of legal age",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Brand already exists",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for brand creation",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveBrand(@RequestBody BrandRequestDto brandRequestDto){
        GenericResponse genericResponse = brandHandler.saveBrand(brandRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPage<BrandModel>> getBrands(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size,
                                                            @RequestParam(defaultValue = "asc") String sortDirection,
                                                            @RequestParam(defaultValue = "brandName") String sortBy) {

        return ResponseEntity.ok(brandHandler.getBrandsPaginated(new PageRequestDomain(page, size, sortDirection, sortBy)));
    }
}
