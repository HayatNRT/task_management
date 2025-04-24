package com.nrt.tms.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {
    private int totalPages;
    private int currentPage;
    private int totalElements;
    private int pageSize;
}
