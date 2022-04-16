package com.nhnacademy.exam.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class CsvDataParser implements DataParser {
    @Override
    public Collection<WaterBill> parse(String fileLocation) {
        Collection<WaterBill> waterBill = new ArrayList<>();
        try (
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileLocation);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader)
        ) {
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] readTariff = line.split(",");
                if (count != 0) {
                    waterBill.add(
                        new WaterBill(readTariff[0], readTariff[1], readTariff[2], readTariff[3],
                            readTariff[4], readTariff[5], readTariff[6]));
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return waterBill;
    }
}
