package com.manu.inditex.capitole_test.price.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("price_list")
    private Integer priceList;

    @JsonProperty("price_start_date")
    private LocalDateTime startDate;

    @JsonProperty("price_end_date")
    private LocalDateTime endDate;

    @JsonProperty("product_price")
    private BigDecimal price;

    private String currency;
}
