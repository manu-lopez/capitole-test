package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.PriceDO;
import com.manu.inditex.capitole_test.price.domain.PriceMapper;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import com.manu.inditex.capitole_test.price.infrastructure.PriceJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PriceRepository {

    private final PriceMapper priceMapper;
    private final PriceJpaRepository priceJpaRepository;

    public PriceDO getById(Long id){
        PriceEntity entity = new PriceEntity();
        try {
            entity = priceJpaRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            // Exception
        }
        return priceMapper.priceEntityToPriceDO(entity);
    }
}
