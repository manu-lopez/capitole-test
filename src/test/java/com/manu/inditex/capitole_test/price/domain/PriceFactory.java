package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.manu.inditex.capitole_test.price.domain.BrandFactory.brandDOFactory;

public class PriceFactory {
    static public PriceDO priceDOFactory(){
        return PriceDO.builder()
                .priceId(1L)
                .brand(brandDOFactory())
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .priceList(1)
                .priority(1)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .build();
    }

    static public PriceDTO priceDTOFactory(){
        return PriceDTO.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .build();
    }
}
