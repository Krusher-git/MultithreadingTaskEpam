package com.kozich.multithreading.parser;

import com.kozich.multithreading.exception.ThreadingException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValueParser {
    private static final Logger logger = LogManager.getLogger();
    private final String SPLIT_VALUE_REGEXP = "[^\\d]+";
    private final String INTEGER_REGEXP = "\\d+";

    public List<Integer> parseIncomeParameters(Optional<String> incomeString) throws ThreadingException {
        if (incomeString.isEmpty()) {
            logger.log(Level.ERROR, "Corrupted data from file");
            throw new ThreadingException("The incoming string from file is empty");
        }
        String valuesString = incomeString.get();
        String[] values = valuesString.split(SPLIT_VALUE_REGEXP);
        List<Integer> parametersList = new ArrayList<>();
        for (String value : values) {
            if (value.matches(INTEGER_REGEXP)) {
                parametersList.add(Integer.parseInt(value));
            }
        }
        return parametersList;
    }
}
