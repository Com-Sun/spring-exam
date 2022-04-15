package com.nhnacademy.exam.config;

import com.nhnacademy.exam.parser.CsvDataParser;
import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;

public class MainConfiguration {

    public TariffRepository tariffRepository() {
        return new TariffRepositoryImpl(new CsvDataParser());
    }

    public DataParser dataParser () {
        return new CsvDataParser();
    }

}
