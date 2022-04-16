package com.nhnacademy.exam.config;

import com.nhnacademy.exam.parser.CsvDataParser;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.report.ResultReport;
import com.nhnacademy.exam.report.ResultReportImpl;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;
import com.nhnacademy.exam.service.WaterUsageFeeService;
import com.nhnacademy.exam.service.WaterUsageFeeServiceImpl;
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

    @Bean
    public WaterUsageFeeService waterUsageFeeService() {
        return new WaterUsageFeeServiceImpl(tariffRepository());
    }

    @Bean
    public ResultReport resultReport() {
        return new ResultReportImpl();
    }

}
