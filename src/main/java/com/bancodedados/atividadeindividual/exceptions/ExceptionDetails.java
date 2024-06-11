package com.bancodedados.atividadeindividual.exceptions;


import java.time.LocalDateTime;

public class ExceptionDetails {

    private Integer httpStatus;
    private LocalDateTime timeStamp;
    private String exception;

    public ExceptionDetails(Integer httpStatus, LocalDateTime timeStamp, String exception) {
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
        this.exception = exception;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}