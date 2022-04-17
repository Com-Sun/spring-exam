package com.nhnacademy.exam.report;

import com.nhnacademy.exam.parser.WaterBill;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 결과를 화면에 출력해주는 클래스입니다.
 */
public class ResultReportImpl implements ResultReport {
    private static final Log logger = LogFactory.getLog(ResultReportImpl.class);

    @Override
    public void report(Collection<WaterBill> waterBills) {
        logger.info(waterBills);
    }
}
