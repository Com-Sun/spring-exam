package com.nhnacademy.exam.config;

import com.nhnacademy.exam.parser.CsvDataParser;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public TariffRepository tariffRepository() {
        return new TariffRepositoryImpl(dataParser());
    }

    @Bean
    public DataParser dataParser () {
        return new CsvDataParser();
    }

}
