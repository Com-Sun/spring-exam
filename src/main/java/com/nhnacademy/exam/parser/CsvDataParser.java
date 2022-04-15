package com.nhnacademy.exam.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvDataParser implements DataParser{
    Collection<Tariff> tariff = new ArrayList<>();

    @Override
    public Collection<Tariff> parse(String fileLocation) throws IOException {
        try(
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileLocation);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader)
            )
        {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] readTariff = line.split(",");
                tariff.add(new Tariff(readTariff[0], readTariff[1], readTariff[2], readTariff[3], readTariff[4], readTariff[5], readTariff[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tariff;
    }
}
