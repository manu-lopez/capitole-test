package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PriceMapper {
    PriceEntity priceDOToPriceEntity(PriceDO priceEntity);
    PriceDO priceEntityToPriceDO(PriceEntity priceDO);
    PriceDTO priceDOToPriceDTO(PriceDO priceDTO);
    PriceDO priceDTOToPriceDO(PriceDTO priceDO);
}
