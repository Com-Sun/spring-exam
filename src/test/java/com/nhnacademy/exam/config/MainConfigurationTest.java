package com.nhnacademy.exam.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.exam.repository.TariffRepository;
import com.nhnacademy.exam.repository.TariffRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainConfigurationTest {

    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(MainConfiguration.class);


    @Test
    @DisplayName("빈이 정상적으로 만들어졌는가")
    void tariffRepository() {
        TariffRepository tariffRepository = ac.getBean("tariffRepository", TariffRepository.class);
        assertThat(tariffRepository).isInstanceOf(TariffRepositoryImpl.class);
    }

//    @Test
//    @DisplayName("빈이 정상적으로 안 만들어졌는가")
//    void tariffRepository2() {
//}

    @Test
    void memberRepository() {
    }

    @Test
    void dataParser() {
    }
}