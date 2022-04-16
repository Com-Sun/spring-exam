package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.parser.WaterBill;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TariffRepositoryImpl implements TariffRepository {
    private final DataParser dataParser;
    private Collection<WaterBill> waterBill;
    private boolean isLoaded = false;

    public TariffRepositoryImpl(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void csvFileLoad(String fileLocation) throws IOException {
        this.waterBill = dataParser.parse(fileLocation);
        isLoaded = true;
    }

    @Override
    public Collection<WaterBill> findFeeByUsedWaterQuantity(int usedWater) {
        return waterBill.stream()
            .filter(waterBill -> waterBill.isUsedWaterOverInterval(usedWater) &&
                waterBill.isUsedWaterUnderInterval(usedWater))
            .sorted(
                Comparator.comparingInt(waterBill -> Integer.parseInt(waterBill.getUnitPrice())))
            .limit(5)
            .collect(Collectors.toList());
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
