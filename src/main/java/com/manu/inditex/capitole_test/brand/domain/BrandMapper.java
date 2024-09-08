package com.manu.inditex.capitole_test.brand.domain;

import com.manu.inditex.capitole_test.brand.domain.entity.BrandDO;
import com.manu.inditex.capitole_test.brand.domain.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {
    BrandDO brandEntityToBrandDO(BrandEntity brandEntity);
    BrandEntity brandDOtoBrandEntity(BrandDO brandDO);
}
