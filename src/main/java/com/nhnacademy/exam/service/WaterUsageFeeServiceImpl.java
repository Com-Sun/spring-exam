package com.nhnacademy.exam.service;

import com.nhnacademy.exam.parser.Tariff;
import com.nhnacademy.exam.parser.WaterBill;
import com.nhnacademy.exam.repository.TariffRepository;
import java.util.ArrayList;
import java.util.Collection;

public class WaterUsageFeeServiceImpl implements WaterUsageFeeService{
    private final TariffRepository tariffRepository;
    private final Collection<WaterBill> waterBills = new ArrayList<>();

    public WaterUsageFeeServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Collection<WaterBill> calculateBillTotal(int usedWaterQuantity) {
        Collection<Tariff> tempTariffs =
            tariffRepository.findFeeByUsedWaterQuantity(usedWaterQuantity);

        for (Tariff tempTariff : tempTariffs) {
            waterBills.add(new WaterBill(tempTariff.getCity(), tempTariff.getSector(), tempTariff.getUnitPrice(), Integer.parseInt(tempTariff.getUnitPrice()) * usedWaterQuantity));
        }
        return waterBills;
    }
}
