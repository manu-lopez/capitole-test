package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.PriceDO;
import com.manu.inditex.capitole_test.price.domain.PriceMapper;
import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{

    private final PriceMapper priceMapper;
    private final PriceRepository priceRepository;

    @Override
    public PriceDTO getPriceFromParams(LocalDateTime priceDate, Long productId, Long brandId) {

        PriceDO priceDO = priceRepository.getById(1L);

        return priceMapper.priceDOToPriceDTO(priceDO);
    }
}
