package com.manu.inditex.capitole_test.price.application;

import com.manu.inditex.capitole_test.price.domain.PriceDO;
import com.manu.inditex.capitole_test.price.domain.PriceMapper;
import com.manu.inditex.capitole_test.price.domain.dto.PriceDTO;
import com.manu.inditex.capitole_test.price.domain.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.manu.inditex.capitole_test.price.domain.PriceFactory.priceDOFactory;
import static com.manu.inditex.capitole_test.price.domain.PriceFactory.priceDTOFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @Test
    public void givenGetPriceFromParams_whenListWithData_thenReturnPriceDTO(){
        LocalDateTime priceDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Long productId = 35455L;
        Integer brandId = 1;

        List<PriceDO> priceDOList = new ArrayList<>();
        priceDOList.add(priceDOFactory());
        PriceDTO expectedDTO = priceDTOFactory();

        when(this.priceRepository.getByParams(priceDate, productId, brandId)).thenReturn(priceDOList);
        when(this.priceMapper.priceDOToPriceDTO(priceDOList.get(0))).thenReturn(expectedDTO);

        PriceDTO result = this.priceService.getPriceFromParams(priceDate, productId, brandId);

        verify(this.priceRepository, times(1)).getByParams(priceDate, productId, brandId);
        verify(this.priceMapper, times(1)).priceDOToPriceDTO(priceDOList.get(0));
        assertEquals(expectedDTO, result);
    }

    @Test
    void givenGetPriceFromParams_whenListIsEmpty_thenThrowError(){
        LocalDateTime priceDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Long productId = 35455L;
        Integer brandId = 1;

        List<PriceDO> priceDOList = new ArrayList<>();

        when(this.priceRepository.getByParams(priceDate, productId, brandId)).thenReturn(priceDOList);

        assertThrows(PriceNotFoundException.class, () -> this.priceService.getPriceFromParams(priceDate, productId, brandId));
        verify(this.priceRepository, times(1)).getByParams(priceDate, productId, brandId);
        verify(this.priceMapper, times(0)).priceDOToPriceDTO(any(PriceDO.class));
    }
}
