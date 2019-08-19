package com.switchfully.maven.exchange.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StockRepositoryTest {

    @Test
    void getStockInformation_givenAExistingStockId_thenReturnStock() {
        // GIVEN & WHEN
        Stock actualStock = StockRepository.getStockInformation("AA");

        // THEN
        assertThat(actualStock.getId()).isEqualTo("AA");
        assertThat(actualStock.getName()).isEqualTo("Ambro AN");
        assertThat(actualStock.getPrice()).isNull();
    }

    @Test
    void getStockInformation_givenAUnknownStockId_thenThrowException() {
        // GIVEN & WHEN
        String expectedMessage = Assertions.assertThrows(IllegalArgumentException.class,
                () -> StockRepository.getStockInformation("XXX"))
                .getMessage();

        // THEN
        assertThat(expectedMessage).isEqualTo("No stock found for id:XXX");
    }

}
