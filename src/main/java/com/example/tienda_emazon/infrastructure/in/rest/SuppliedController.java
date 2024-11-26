package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.SuppliedRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISuppliedHandler;
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

import static com.example.tienda_emazon.domain.util.Constants.AUX_ROLE;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/supplied")
@SecurityRequirement(name = "jwt")
public class SuppliedController {

    private final ISuppliedHandler suppliedHandler;

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
        GenericResponse genericResponse = suppliedHandler.addSupplied(suppliedRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
}
