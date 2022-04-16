package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.parser.DataParser;
import com.nhnacademy.exam.parser.Tariff;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TariffRepositoryImpl implements TariffRepository {
    private final DataParser dataParser;
    private Collection<Tariff> tariff;
    private boolean isLoaded = false;

    public TariffRepositoryImpl(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public void csvFileLoad(String fileLocation) throws IOException {
        this.tariff = dataParser.parse(fileLocation);
        isLoaded = true;
    }

    @Override
    public Collection<Tariff> findFeeByUsedWaterQuantity(int usedWater) {
        return tariff.stream()
            .filter(tariff -> tariff.isUsedWaterOverInterval(usedWater) &&
                tariff.isUsedWaterUnderInterval(usedWater))
            .sorted(
                Comparator.comparingInt(waterBill -> Integer.parseInt(waterBill.getUnitPrice())))
            .limit(5)
            .collect(Collectors.toList());
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
