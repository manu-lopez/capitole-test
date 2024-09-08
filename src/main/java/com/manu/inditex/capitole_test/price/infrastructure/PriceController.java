package com.manu.inditex.capitole_test.price.infrastructure;

import com.manu.inditex.capitole_test.price.domain.exception.PriceNotFoundException;
import com.manu.inditex.capitole_test.price.application.PriceService;
import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<PriceDTO> getPrice(@RequestParam("priceDate") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime priceDate,
                                             @RequestParam("productId") Long productId,
                                             @RequestParam("brandId") Long brandId){
        PriceDTO priceResponse = priceService.getPriceFromParams(priceDate, productId, brandId);
        return new ResponseEntity<>(priceResponse, HttpStatus.OK);
    }

    // ----------------
    // ERROR HANDLERS
    // ----------------

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> priceNotFoundHandler(PriceNotFoundException ex){
        ErrorResponse error = new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
