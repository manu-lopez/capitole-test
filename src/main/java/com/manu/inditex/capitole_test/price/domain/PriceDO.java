package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.brand.domain.entity.BrandDO;
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
public class PriceDO {
    private Long priceId;

    private BrandDO brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private String currency;
}
