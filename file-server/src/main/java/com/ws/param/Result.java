package com.ws.param;

import lombok.Data;

/**
 * @author shuo.wang
 * @date 19-9-17
 */

@Data
public class Result<T> {

    private Integer code;
    private T data;
    private String msg;
}
