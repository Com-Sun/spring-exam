package com.nhnacademy.exam.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

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
        dataParser = mock(DataParser.class);
    }

    @Test
    @DisplayName("요금을 찾는 메소드 실행 시 결과 5개가 제대로 나오는지 테스트")
    void findFeeByUsedWaterQuantityTest() throws IOException {
//        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        tariffRepository.jsonFileLoad("Tariff_20220331.json");
        assertThat(tariffRepository.findFeeByUsedWaterQuantity(1000)).hasSize(5);
    }
}