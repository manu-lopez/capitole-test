package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.PriceDO;
import com.manu.inditex.capitole_test.price.domain.PriceMapper;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import com.manu.inditex.capitole_test.price.domain.exception.PriceNotFoundException;
import com.manu.inditex.capitole_test.price.infrastructure.PriceJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class PriceRepository {

    private final PriceMapper priceMapper;
    private final PriceJpaRepository priceJpaRepository;

    public List<PriceDO> getByParams(LocalDateTime priceDate, Long productId, Integer brandId) {
        final List<PriceEntity> entityList;

        try {
            entityList = priceJpaRepository.getPriceByParams(priceDate, productId, brandId).orElseThrow();
        } catch (NoSuchElementException e){
            throw new PriceNotFoundException(String.format("Price not found for product ID %s", productId));
        }catch (Exception e) {
            throw new RuntimeException("Error while trying to get the price");
        }

        return priceMapper.priceEntityListToPriceDOList(entityList);
    }

    public List<PriceDO> getAllPrices() {
        final List<PriceEntity> entityList;

        try {
            entityList = priceJpaRepository.findAll();
        }catch (Exception e) {
            throw new RuntimeException("Error while trying to get the price");
        }

        return priceMapper.priceEntityListToPriceDOList(entityList);
    }
}
