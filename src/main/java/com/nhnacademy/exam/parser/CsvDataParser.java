package com.nhnacademy.exam.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CsvDataParser implements DataParser{
    Collection<WaterBill> waterBill = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private final int input = sc.nextInt();
    @Override
    public Collection<WaterBill> parse(String fileLocation) throws IOException {
        try(
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileLocation);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader)
            )
        {
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] readTariff = line.split(",");
                if (count != 0) {
                    waterBill.add(new WaterBill(readTariff[0], readTariff[1], readTariff[2], readTariff[3], readTariff[4], readTariff[5], readTariff[6], Integer.parseInt(readTariff[6]) * input));
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return waterBill;
    }

    public int getInput() {
        return input;
    }
}
