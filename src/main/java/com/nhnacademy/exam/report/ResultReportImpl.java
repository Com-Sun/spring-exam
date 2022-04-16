package com.nhnacademy.exam.report;

import com.nhnacademy.exam.parser.WaterBill;
import java.util.Collection;

public class ResultReportImpl implements ResultReport{
    @Override
    public void report(Collection<WaterBill> waterBills) {
        System.out.println(waterBills);
    }
}
