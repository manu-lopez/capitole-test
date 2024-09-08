package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {
    PriceDTO getPriceFromParams(LocalDateTime priceDate, Long productId, Integer brandId);

    PriceDTO getPriceFromParamsStreams(LocalDateTime priceDate, Long productId, Integer brandId);
}
