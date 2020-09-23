package org.yearup.moviecatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessDetail {

    private int code;
    private String message;
    private Object data;

    public SuccessDetail() { }

    public SuccessDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SuccessDetail(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
