package com.nhnacademy.exam.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JSON형식의 파일을 파싱합니다.
 * 소나린트 VAR을 사용하라는 경고를 무시합니다.
 */

@SuppressWarnings("squid:S6212")
public class JsonDataParser implements DataParser {
    private static final String FILTER = "[^0-9]";

    @Override
    public Collection<Tariff> parse(String fileLocation) throws IOException {
        List<Tariff> tariff = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();


        File file = new File(ClassLoader.getSystemResource(fileLocation).getFile());

        for (Object o : mapper.readValue(file, List.class)) {
            String[] temp = o.toString().split(",");
            tariff.add(
                new Tariff(temp[0], temp[1], temp[2], temp[3], temp[4].replaceAll(FILTER,""),
                    temp[5].replaceAll(FILTER,""), temp[6].replaceAll(FILTER,"")));
        }
        return tariff;
    }
}

