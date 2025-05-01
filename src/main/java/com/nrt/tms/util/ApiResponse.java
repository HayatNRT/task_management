package com.nrt.tms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private final String responseCode;
    private final String responseDescription;
    private final T response;
    private final boolean isOkay;
    private PaginationInfo paginationInfo;

    public ApiResponse(ResponseCode responseCode, T response, boolean isOkay) {
        this.responseCode = responseCode.getCode();
        this.responseDescription = responseCode.getMessage();
        this.response = response;
        this.isOkay = isOkay;
    }


    public ApiResponse(ResponseCode responseCode, T response, boolean isOkay, PaginationInfo paginationInfo) {
        this(responseCode, response, isOkay);
        this.paginationInfo = paginationInfo;
    }


}
