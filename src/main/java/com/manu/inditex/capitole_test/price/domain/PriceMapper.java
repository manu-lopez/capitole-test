package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.brand.domain.BrandMapper;
import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = BrandMapper.class)
public interface PriceMapper {
    List<PriceDO> priceEntityListToPriceDOList(List<PriceEntity> priceEntity);

    PriceDO priceEntityToPriceDO(PriceEntity priceEntity);

    @Mapping(target = "brandId", source ="brand.id")
    PriceDTO priceDOToPriceDTO(PriceDO priceDO);
}
