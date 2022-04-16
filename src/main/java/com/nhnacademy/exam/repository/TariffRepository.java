package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.parser.WaterBill;
import java.io.IOException;
import java.util.Collection;

public interface TariffRepository {
    void csvFileLoad(String fileLocation) throws IOException;

    Collection<WaterBill> findFeeByUsedWaterQuantity(int usedWater);

}
