package com.nhnacademy.exam.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Collection;
import org.junit.jupiter.api.*;

class CsvDataParserTest {
    DataParser csvDataParser;
    Collection<WaterBill> waterBill;

    @BeforeEach
    void setUp() {
        csvDataParser = new CsvDataParser();
    }

    @Test
    void parse() throws IOException {
        waterBill = csvDataParser.parse("Tariff_20220331.csv");
        assertThat(waterBill).isNotNull();

    }
}