package com.manu.inditex.capitole_test.price.infrastructure;

import com.manu.inditex.capitole_test.price.domain.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceJpaRepository extends JpaRepository <PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.brand.id = :brandId AND p.productId = :productId " +
            "AND :priceDate BETWEEN p.startDate and p.endDate " +
            "ORDER BY p.priority DESC, p.startDate ASC")
    Optional<List<PriceEntity>> getPriceByParams(@Param("priceDate") LocalDateTime priceDate,
                                                   @Param("productId") Long productId,
                                                   @Param("brandId") Long brandId);
}
