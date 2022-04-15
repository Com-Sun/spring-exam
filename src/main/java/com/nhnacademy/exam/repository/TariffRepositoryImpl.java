package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.parser.Tariff;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TariffRepositoryImpl implements TariffRepository{
    private final DataParser dataParser;
    private Collection<Tariff> waterBill;
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
    public Collection<Tariff> findFeeByUsedWaterQuantity(int usedWater) {
        return waterBill.stream()
            .filter(waterBill -> waterBill.isUsedWaterOverInterval(usedWater))
            .filter(waterBill -> waterBill.isUsedWaterUnderInterval(usedWater))
            .collect(Collectors.toList());
    }

    @Override
    public boolean isLoaded() {
        return isLoaded;
    }
}
