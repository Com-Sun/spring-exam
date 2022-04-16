package com.nhnacademy.exam;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.parser.WaterBill;
import com.nhnacademy.exam.report.ResultReport;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.service.WaterUsageFeeService;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BootStrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(MainConfiguration.class);
        WaterUsageFeeService waterUsageFeeService =
            ac.getBean("waterUsageFeeService", WaterUsageFeeService.class);
        TariffRepository tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
        ResultReport resultReport = ac.getBean("resultReport", ResultReport.class);

        tariffRepository.csvFileLoad("Tariff_20220331.csv");
        Scanner sc = new Scanner(System.in);

        while (true) {
            Collection<WaterBill> waterBills = waterUsageFeeService.calculateBillTotal(sc.nextInt());
            resultReport.report(waterBills);
        }


    }
}

