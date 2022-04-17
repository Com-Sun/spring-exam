package com.nhnacademy.exam.report;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.service.WaterUsageFeeService;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ResultReportImplTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfiguration.class);
    WaterUsageFeeService waterUsageFeeService;
    TariffRepository tariffRepository;
    ResultReport resultReport;

    @BeforeEach
    void setUp() throws IOException {
        waterUsageFeeService = ac.getBean("waterUsageFeeService", WaterUsageFeeService.class);
        tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
//        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        tariffRepository.jsonFileLoad("Tariff_20220331.json");
        resultReport = ac.getBean("resultReport", ResultReport.class);
    }

    @Test
    @DisplayName("Bean 주입이 프록시로 대체되었는가 테스트")
    void beanTest(){
        assertThat(resultReport).isNotInstanceOf(ResultReportImpl.class);
    }

    @Test
    @DisplayName("터미널에 제대로 값이 찍히는지 확인하는 테스트")
    void report() {
        resultReport.report(waterUsageFeeService.calculateBillTotal(1000));

    }
}