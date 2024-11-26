package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISupplyHandler;
import com.example.tienda_emazon.domain.model.SupplyModel;
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
import static com.example.tienda_emazon.domain.util.Constants.AUX_ROLE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "jwt")
public class SupplyController {

    private final ISupplyHandler supplyHandler;


    @Secured({ADMIN_ROLE})
    @Operation(summary = "Add a new item",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Item created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "403", description = "The user must be of legal age",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Item already exists",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for item creation",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveSupply(@RequestBody SupplyRequestDto supplyRequestDto){
        GenericResponse genericResponse = supplyHandler.saveSupply(supplyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPage<SupplyModel>> getSupply(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(defaultValue = "asc") String sortDirection,
                                                             @RequestParam(defaultValue = "supplyName") String sortBy){
        return ResponseEntity.ok(supplyHandler.getSuppliesPaginated(new PageRequestDomain(page, size, sortDirection, sortBy)));
    }

    @Secured({AUX_ROLE})
    @Operation(summary = "Add a new supplied",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Supplied created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "403", description = "The user must be of legal age",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "409", description = "Supplied already exists",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for category creation",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/add")
    public ResponseEntity<GenericResponse> addSupply(@RequestBody SuppliedRequestDto suppliedRequestDto){
        GenericResponse genericResponse = supplyHandler.addSupplied(suppliedRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

}
