package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceMapper {
    PriceEntity priceDOToPriceEntity(PriceDO priceDO);

    PriceDO priceEntityToPriceDO(PriceEntity priceEntity);

    @Mapping(target = "brandId", source ="brand.id")
    PriceDTO priceDOToPriceDTO(PriceDO priceDO);

    PriceDO priceDTOToPriceDO(PriceDTO priceDTO);
}
