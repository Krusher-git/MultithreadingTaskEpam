package com.kozich.multithreading.parser;

import com.kozich.multithreading.exception.ThreadingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValueParser {
    private final String SPLIT_VALUE_REGEXP = "^\\d+";

    public List<Integer> parseIncomeParameters(Optional<String> incomeString) throws ThreadingException {
        if (incomeString.isEmpty()) {
            throw new ThreadingException("The incoming string from file is empty");
        }
        String valuesString = incomeString.get();
        String[] values = valuesString.split(SPLIT_VALUE_REGEXP);
        List<Integer> parametersList = new ArrayList<>();
        for (String value : values) {
            parametersList.add(Integer.parseInt(value));
        }
        return parametersList;
    }
}
