package com.cb.portfolio.helpers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationResponse {
    private int page;
    private Long totalPages;
    private Object data;

    private void calculateActualPage(int offset, int limit) {
        this.page = offset+1;
    }

    public PaginationResponse(int offset, int limit, Long totalPages, Object data) {
        this.totalPages = totalPages/limit+1;
        this.data = data;
        this.calculateActualPage(offset, limit);
    }
}
