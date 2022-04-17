package com.nhnacademy.exam;

import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.parser.WaterBill;
import com.nhnacademy.exam.report.ResultReport;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.service.WaterUsageFeeService;
import java.io.IOException;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 메인클래스입니다.
 * 소나린트 VAR을 사용하라는 경고를 무시합니다.
 */
@SuppressWarnings("squid:S6212")
public class BootStrap {
    private static final Log logger = LogFactory.getLog(BootStrap.class);

    /**
     * 메인메서드입니다.
     */
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(MainConfiguration.class);

        WaterUsageFeeService waterUsageFeeService =
            ac.getBean("waterUsageFeeService", WaterUsageFeeService.class);

        TariffRepository tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
        ResultReport resultReport = ac.getBean("resultReport", ResultReport.class);

        tariffRepository.jsonFileLoad("Tariff_20220331.json");
        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;
        while (isContinue) {
            try {
                logger.info("사용량을 입력해주세요. 숫자가 아닐 시 exit");
                Collection<WaterBill> waterBills =
                    waterUsageFeeService.calculateBillTotal(sc.nextInt());
                resultReport.report(waterBills);
            } catch (InputMismatchException e) {
                isContinue = false;
                logger.info("서비스를 종료합니다.");
            }
        }

    }
}

