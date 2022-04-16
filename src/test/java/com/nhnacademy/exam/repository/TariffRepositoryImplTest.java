package com.nhnacademy.exam.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.parser.CsvDataParser;
import com.nhnacademy.exam.parser.DataParser;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TariffRepositoryImplTest {
    TariffRepository tariffRepository;
    DataParser dataParser;
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfiguration.class);

    @BeforeEach
    void setUp() {
        tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
        dataParser = ac.getBean("dataParser", CsvDataParser.class);
    }

    @Test
    @DisplayName("저장소가 정상적으로 로드되었는지를 확인하는 테스트")
    void csvFileLoad() throws IOException {
        TariffRepositoryImpl tariffRepositoryImpl = ac.getBean("tariffRepository", TariffRepositoryImpl.class);
        assertThat(tariffRepositoryImpl.isLoaded()).isFalse();
        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        assertThat(tariffRepositoryImpl.isLoaded()).isTrue();
    }

    @Test
    void findFeeByUsedWaterQuantity() {

    }
}