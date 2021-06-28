package com.kozich.multithreading.service;

import com.kozich.multithreading.exception.ThreadingException;
import com.kozich.multithreading.parser.ValueParser;
import com.kozich.multithreading.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FerryServiceImpl implements FerryService {
    private static Logger logger = LogManager.getLogger();

    /**
     * @return true if work has been ended
     * else false
     */
    public boolean vehicleDelivery() {
        List<Integer> parameters = null;
        try {
            CustomFileReader fileReader = new CustomFileReader();
            ValueParser parser = new ValueParser();
            parameters = parser.parseIncomeParameters(fileReader.readString("data/source.txt"));

        } catch (ThreadingException e) {
            logger.log(Level.ERROR, "Exception while file processing", e);
        }

        return false;
    }
}
