package com.nhnacademy.exam.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonDataParserTest {
    JsonDataParser jsonDataParser;
    Collection<Tariff> tariff;

    @BeforeEach
    void setUp() {
        jsonDataParser = new JsonDataParser();
    }

    @Test
    @DisplayName("파싱 후 데이터 303개가 제대로 들어갔는지 확인하는 테스트")
    void parse() throws IOException {
        tariff = jsonDataParser.parse("Tariff_20220331.json");
        assertThat(tariff).hasSize(303);

    }
}