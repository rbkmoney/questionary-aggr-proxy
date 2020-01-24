package com.rbkmoney.questionary.aggr.proxy.exception;

public class DaDataRequestException extends RuntimeException {

    public DaDataRequestException() {
    }

    public DaDataRequestException(String message) {
        super(message);
    }

    public DaDataRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaDataRequestException(Throwable cause) {
        super(cause);
    }

    public DaDataRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
