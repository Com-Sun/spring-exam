package com.nhnacademy.exam.parser;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface DataParser {
    Collection<Tariff> parse(String fileLocation) throws IOException;
}
