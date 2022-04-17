package com.nhnacademy.exam.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonDataParserTest {
    JsonDataParser jsonDataParser;

    @BeforeEach
    void setUp() {
        jsonDataParser = new JsonDataParser();
    }

    @Test
    @DisplayName("파싱이 제대로 작동하는지 테스트")
    void parse() throws IOException {
        assertThat(jsonDataParser.parse("Tariff_20220331.json")).isNotNull();
    }
}