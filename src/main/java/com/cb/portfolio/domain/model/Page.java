package com.cb.portfolio.domain.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Page<T> {
    private final List<T> content;
    private final int pageNumber;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
}
