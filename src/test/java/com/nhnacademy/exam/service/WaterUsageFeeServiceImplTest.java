package com.nhnacademy.exam.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.repository.TariffRepository;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class WaterUsageFeeServiceImplTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfiguration.class);
    WaterUsageFeeService waterUsageFeeService;
    TariffRepository tariffRepository;

    @BeforeEach
    void setUp() throws IOException {
        waterUsageFeeService = ac.getBean("waterUsageFeeService", WaterUsageFeeService.class);
        tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
//        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        tariffRepository.jsonFileLoad("Tariff_20220331.json");
    }

    @Test
    @DisplayName("WaterBill이 제대로 만들어지는가를 테스트.")
    void calculateBillTotalTest() {
        assertThat(waterUsageFeeService.calculateBillTotal(1000).toString()).containsAnyOf("고령군");
        assertThat(waterUsageFeeService.calculateBillTotal(1000).toString()).containsAnyOf("통영시");
        assertThat(waterUsageFeeService.calculateBillTotal(1000).toString()).containsAnyOf("금산군");
        assertThat(waterUsageFeeService.calculateBillTotal(1000).toString()).containsAnyOf("나주시");
        assertThat(waterUsageFeeService.calculateBillTotal(1000).toString()).containsAnyOf("장흥군");
    }

}