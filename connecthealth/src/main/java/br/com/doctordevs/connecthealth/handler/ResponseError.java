package br.com.doctordevs.connecthealth.handler;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError {
    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode;
    private String error;
    private List<String> errors;

    public ResponseError(String error, int statusCode, List<String> errors) {
        this.error = error;
        this.statusCode = statusCode;
        this.errors = errors;
    }
}