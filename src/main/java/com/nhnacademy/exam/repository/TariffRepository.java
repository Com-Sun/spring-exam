package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.parser.Tariff;
import java.io.IOException;
import java.util.Collection;

public interface TariffRepository {
    void csvFileLoad(String fileLocation) throws IOException;

    Collection<Tariff> findFeeByUsedWaterQuantity(int usedWater);

}
