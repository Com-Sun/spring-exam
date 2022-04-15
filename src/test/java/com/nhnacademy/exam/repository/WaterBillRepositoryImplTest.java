package com.nhnacademy.exam.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.parser.WaterBill;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WaterBillRepositoryImplTest {
    TariffRepository tariffRepository;
    DataParser dataParser;
    List<WaterBill> waterBill;

    @BeforeEach
    void setUp() {
        MainConfiguration mainConfiguration = new MainConfiguration();
        tariffRepository = mainConfiguration.tariffRepository();
        dataParser = mainConfiguration.dataParser();
    }

    @Test
    void csvFileLoad() throws IOException {
        assertThat(tariffRepository.isLoaded()).isFalse();
        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        assertThat(tariffRepository.isLoaded()).isTrue();
    }

    @Test
    void findFeeByUsedWaterQuantity() {

    }
}