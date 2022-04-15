package com.nhnacademy.exam.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.*;

class CsvDataParserTest {
    DataParser csvDataParser;
    Collection<Tariff> tariff;

    @BeforeEach
    void setUp() {
        csvDataParser = new CsvDataParser();
    }

    @Test
    void parse() throws IOException {
        tariff = csvDataParser.parse("Tariff_20220331.csv");
        assertThat(tariff).isNotNull();

    }
}