package com.nhnacademy.exam.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.exam.parser.CsvDataParser;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainConfigurationTest {

    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(MainConfiguration.class);

    @Test
    @DisplayName("빈을 통해 구현된 클래스가 프록시로 대체되었는가")
    void tariffRepository() {
        TariffRepository tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
        assertThat(tariffRepository).isNotInstanceOf(TariffRepositoryImpl.class);
    }

    @Test
    @DisplayName("빈을 통해 구현된 클래스가 프록시로 대체되었는가")
    void dataParser() {
        DataParser dataParser = ac.getBean("dataParser", DataParser.class);
        assertThat(dataParser).isNotInstanceOf(CsvDataParser.class);
    }
}