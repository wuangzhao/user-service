package org.angzhao.demo.service.user.common;

import lombok.Data;

import java.util.Collection;

@Data
public class Page<T> {
    private Collection<T> result;

    private int pageSize = 0;

    private int pageNo = 1;

    private long total = 0;
}

