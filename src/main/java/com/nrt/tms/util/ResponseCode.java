package com.nrt.tms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseCode {
    private String code;
    private String message;
}