package com.nhnacademy.exam.parser;

import java.io.IOException;
import java.util.Collection;

public interface DataParser {
    Collection<WaterBill> parse(String fileLocation) throws IOException;
}
