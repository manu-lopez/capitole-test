package com.manu.inditex.capitole_test.price.infrastructure;

import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends JpaRepository <PriceEntity, Long> {
}
