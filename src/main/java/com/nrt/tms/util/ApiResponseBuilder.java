package com.nrt.tms.util;

import com.nrt.tms.dto.ProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiResponseBuilder {

    private final ResponseCodeResolver resolver;

    public <T> ResponseEntity<ApiResponse<T>> ok(String key, T data) {
        return ResponseEntity.ok(new ApiResponse<>(resolver.get(key), data, true));
    }

    public <T> ResponseEntity<ApiResponse<T>> okWithPagination(String key, T data, Page<?> page) {
        return ResponseEntity.ok(new ApiResponse<>(resolver.get(key), data, true, buildPaginationInfo(page)));
    }

    public ResponseEntity<ApiResponse<String>> error(String key, Exception e, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse<>(resolver.get(key), e.getMessage(), false));
    }

    private PaginationInfo buildPaginationInfo(Page<?> page) {
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPage(page.getNumber());
        paginationInfo.setPageSize(page.getSize());
        paginationInfo.setTotalElements(page.getTotalElements());
        paginationInfo.setTotalPages(page.getTotalPages());
        return paginationInfo;
    }


}
