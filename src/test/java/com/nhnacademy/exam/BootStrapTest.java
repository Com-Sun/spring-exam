package com.nhnacademy.exam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.nhnacademy.exam.config.MainConfiguration;
import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.service.WaterUsageFeeService;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BootStrapTest {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(MainConfiguration.class);
    WaterUsageFeeService waterUsageFeeService =
        ac.getBean("waterUsageFeeService", WaterUsageFeeService.class);

    TariffRepository tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);

    @Test
    @DisplayName("json 로드 전 Null포인터 익셉션이 발생하는지 테스트. 이후 findFeeByUsedWaterQuantity 메소드가 제대로 작동하는지 테스트.")
    void bootStrapRepositoryTest() throws IOException {
        assertThrows(NullPointerException.class , ()-> waterUsageFeeService.calculateBillTotal(1000));
        tariffRepository.jsonFileLoad("Tariff_20220331.json");
        assertThat(tariffRepository.findFeeByUsedWaterQuantity(1000)).hasSize(5);
    }

    @Test
    @DisplayName("json 로드 전 Null포인터 익셉션이 발생하는지 테스트. 이후 calculateBillTotal 메소드가 제대로 동작하는지 테스트.")
    void waterUsageFeeServiceTest() throws IOException {
        assertThrows(NullPointerException.class , ()-> waterUsageFeeService.calculateBillTotal(1000));
        tariffRepository.jsonFileLoad("Tariff_20220331.json");
        assertThat(waterUsageFeeService.calculateBillTotal(1000)).hasSize(5);
    }

}