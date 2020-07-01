package org.yearup.moviecatalog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ErrorDetail {

    private int code;
    private String message;

    public ErrorDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
