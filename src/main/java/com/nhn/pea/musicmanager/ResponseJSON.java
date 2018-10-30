package com.nhn.pea.musicmanager;


import org.springframework.http.HttpStatus;

public class ResponseJSON<T> {
    private String status;
    private int code;
    private String message;
    private T result;

    public ResponseJSON(HttpStatus code, String message, T result) {
        this.status = code.getReasonPhrase();
        this.code = code.value();
        this.message = message;
        this.result = result;
    }

    public ResponseJSON(T result){
        status = HttpStatus.OK.getReasonPhrase();
        code = HttpStatus.OK.value();
        message ="Success!";
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
