package com.nhnacademy.exam.service;

import com.nhnacademy.exam.parser.Tariff;
import com.nhnacademy.exam.parser.WaterBill;
import com.nhnacademy.exam.repository.TariffRepository;
import java.util.ArrayList;
import java.util.Collection;


/**
 * 사용자에게 입력값을 받아 최종적으로 WaterBill 객체를 만들어줍니다.
 */
public class WaterUsageFeeServiceImpl implements WaterUsageFeeService {
    private final TariffRepository tariffRepository;


    public WaterUsageFeeServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Collection<WaterBill> calculateBillTotal(int usedWaterQuantity) {
        Collection<WaterBill> waterBills = new ArrayList<>();
        Collection<Tariff> tempTariffs =
            tariffRepository.findFeeByUsedWaterQuantity(usedWaterQuantity);

        for (Tariff tempTariff : tempTariffs) {
            waterBills.add(new WaterBill(tempTariff.getCity(), tempTariff.getSector(),
                tempTariff.getUnitPrice(),
                Integer.parseInt(tempTariff.getUnitPrice()) * usedWaterQuantity));
        }
        return waterBills;
    }
}
