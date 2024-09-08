package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.PriceDO;
import com.manu.inditex.capitole_test.price.domain.PriceMapper;
import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.exception.PriceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{

    private final PriceMapper priceMapper;
    private final PriceRepository priceRepository;

    @Override
    public PriceDTO getPriceFromParams(LocalDateTime priceDate, Long productId, Integer brandId) {

        final List<PriceDO> priceDOList = priceRepository.getByParams(priceDate, productId, brandId);

        if(priceDOList.isEmpty()){
            throw new PriceNotFoundException(String.format("Price not found for product ID %s", productId));
        }

        priceDOList.sort(Comparator.comparing(PriceDO::getPriority).reversed());

        return priceMapper.priceDOToPriceDTO(priceDOList.get(0));
    }


    /**
     * This method is just an example to show how Streams can be used to get the correct price from a dataset.
     * */
    @Override
    public PriceDTO getPriceFromParamsStreams(LocalDateTime priceDate, Long productId, Integer brandId) {
        final List<PriceDO> priceDOList = priceRepository.getAllPrices();

        if(priceDOList.isEmpty()){
            throw new PriceNotFoundException(String.format("Price not found for product ID %s", productId));
        }

        final List<PriceDO> filteredList = priceDOList.stream()
                .filter(p -> Objects.equals(p.getProductId(), productId)
                        && Objects.equals(p.getBrand().getId(), brandId)
                        && !priceDate.isBefore(p.getStartDate())
                        && !priceDate.isAfter(p.getEndDate()))
                .sorted(Comparator.comparing(PriceDO::getPriority).reversed())
                .toList();

        return priceMapper.priceDOToPriceDTO(filteredList.get(0));
    }


}
