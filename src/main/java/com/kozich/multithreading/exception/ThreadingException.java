package com.kozich.multithreading.exception;

public class ThreadingException extends Exception {
    public ThreadingException() {
    }

    public ThreadingException(String message) {
        super(message);
    }

    public ThreadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThreadingException(Throwable cause) {
        super(cause);
    }
}
