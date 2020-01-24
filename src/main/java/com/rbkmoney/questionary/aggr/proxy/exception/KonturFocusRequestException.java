package com.rbkmoney.questionary.aggr.proxy.exception;

public class KonturFocusRequestException extends RuntimeException {

    public KonturFocusRequestException() {
    }

    public KonturFocusRequestException(String message) {
        super(message);
    }

    public KonturFocusRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public KonturFocusRequestException(Throwable cause) {
        super(cause);
    }

    public KonturFocusRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
