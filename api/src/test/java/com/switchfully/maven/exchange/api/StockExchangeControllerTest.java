package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.domain.StockPrice;
import com.switchfully.maven.exchange.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static com.switchfully.maven.exchange.domain.StockCurrency.EUR;
import static org.assertj.core.api.Assertions.assertThat;

class StockExchangeControllerTest {

    /**
     * We mock the StockService.
     * The StockService can be broken,
     * it will not affect these test due to mocking.
     *
     * We can mock the StockService because we
     * applied Inversion of Control - Constructor Dependency Injection
     * on the StockExchangeController
     *
     * Same goes for the StockMapper
     */
    @Test
    void getStock_givenAStockId_thenReturnStock() {
        // GIVEN
        StockMapper stockMapper = Mockito.mock(StockMapper.class);
        StockService stockService = Mockito.mock(StockService.class);
        StockExchangeController controller = new StockExchangeController(stockService, stockMapper);

        Stock enrichedStock = createEnrichedStock("ABC", "AyBeCe", new StockPrice(new BigDecimal(10), EUR));
        Mockito.when(stockService.getStock("ABC"))
                .thenReturn(enrichedStock);
        Mockito.when(stockMapper.mapToDto(enrichedStock))
                .thenReturn(new StockDto("ABC", "AyBeCe", new BigDecimal(10), EUR.getLabel()));


        // WHEN
        StockDto stockDto = controller.getStock("ABC");

        // THEN
        assertThat(stockDto.getId()).isEqualTo("ABC");
        assertThat(stockDto.getName()).isEqualTo("AyBeCe");
        assertThat(stockDto.getPrice()).isEqualTo(new BigDecimal(10));
        assertThat(stockDto.getCurrency()).isEqualTo(EUR.getLabel());
    }

    private Stock createEnrichedStock(String id, String name, StockPrice stockPrice) {
        Stock stock = new Stock(id, name);
        stock.setPrice(stockPrice);
        return stock;
    }

}
