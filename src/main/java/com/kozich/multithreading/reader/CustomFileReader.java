package com.kozich.multithreading.reader;

import com.kozich.multithreading.exception.ThreadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class CustomFileReader {
    public Optional<String> readString(String path) throws ThreadingException {
        String result;
        try {
            result = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new ThreadingException(e);
        }
        return Optional.ofNullable(result);
    }
}
