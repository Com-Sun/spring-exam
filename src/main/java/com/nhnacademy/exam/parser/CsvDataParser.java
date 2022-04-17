package com.nhnacademy.exam.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Csv파일을 파싱합니다.
 *
 */
@SuppressWarnings("squid:S6212") //var을 사용하라는 경고 무시
public class CsvDataParser implements DataParser {
    @Override
    public Collection<Tariff> parse(String fileLocation) {
        Collection<Tariff> tariff = new ArrayList<>();
        try (
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileLocation);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader)
        ) {
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] readTariff = line.split(",");
                if (count != 0) {
                    tariff.add(
                        new Tariff(readTariff[0], readTariff[1], readTariff[2], readTariff[3],
                            readTariff[4], readTariff[5], readTariff[6]));
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tariff;
    }
}
