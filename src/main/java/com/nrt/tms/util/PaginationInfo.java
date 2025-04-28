package com.nrt.tms.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {
    private long totalPages;
    private long currentPage;
    private long totalElements;
    private long pageSize;
}
