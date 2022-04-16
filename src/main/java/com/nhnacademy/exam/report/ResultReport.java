package com.nhnacademy.exam.report;

import com.nhnacademy.exam.parser.Tariff;
import com.nhnacademy.exam.parser.WaterBill;
import java.util.Collection;

public interface ResultReport {
    void report(Collection<WaterBill> waterBills);
}
