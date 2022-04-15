package com.nhnacademy.exam;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;
import java.io.IOException;
import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        MainConfiguration mainConfiguration = new MainConfiguration();
        TariffRepository tariffRepository;
        tariffRepository = mainConfiguration.tariffRepository();

        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        

        System.out.println(tariffRepository.findFeeByUsedWaterQuantity());
    }
}

