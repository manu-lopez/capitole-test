package com.manu.inditex.capitole_test.price.domain;

import com.manu.inditex.capitole_test.brand.domain.entity.BrandDO;

public class BrandFactory {
    static public BrandDO brandDOFactory() {
        return BrandDO.builder()
                .id(1)
                .name("ZARA")
                .build();
    }
}
