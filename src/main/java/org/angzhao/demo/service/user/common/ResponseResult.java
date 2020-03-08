package org.angzhao.demo.service.user.common;

import lombok.Data;

@Data
public final class ResponseResult<T> {
    private long total = 0;

    private T data;

    private boolean success = false;

    private String message;
}
