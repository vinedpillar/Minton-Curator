package com.mintonware.mintoncurator.function.response;

import org.springframework.data.domain.Page;

import java.util.List;

public class MultiResponse<T> {
    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponse(List<T> data, Page page) {
        this.data = data;
        this.pageInfo = new PageInfo(
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
    }
}
