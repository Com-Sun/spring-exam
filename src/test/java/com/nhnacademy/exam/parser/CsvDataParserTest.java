package com.nhnacademy.exam.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.exam.config.MainConfiguration;
import java.io.IOException;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class CsvDataParserTest {
    DataParser csvDataParser;
    Collection<WaterBill> waterBill;
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        MainConfiguration.class);

    @BeforeEach
    void setUp() {
        csvDataParser = ac.getBean("dataParser", DataParser.class);
    }

    @Test
    @DisplayName("데이터 파싱이 제대로 동작하는가.")
    void parse() throws IOException {
        waterBill = csvDataParser.parse("Tariff_20220331.csv");
        assertThat(waterBill).isNotNull();
    }
}