package com.cb.portfolio.helpers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationResponse {
    private int page;
    private Long totalPages;
    private Long totalItems;
    private Object data;

    public PaginationResponse(int offset, int limit, Long totalItems, Object data) {
        this.totalPages = totalItems/limit+1;
        this.data = data;
        this.totalItems = totalItems;
        this.page=offset+1;
    }
}
