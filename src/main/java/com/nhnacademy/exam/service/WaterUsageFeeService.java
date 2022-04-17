package com.nhnacademy.exam.service;

import com.nhnacademy.exam.parser.WaterBill;
import java.util.Collection;

public interface WaterUsageFeeService {
    Collection<WaterBill> calculateBillTotal(int usedWaterQuantity);
}
