package com.cxcs.manger.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonRequest<T> {
    private String orderId;
    private T param;

    @Override
    public String toString() {
        return "CommonRequest{" +
                "orderId='" + orderId + '\'' +
                ", param=" + param +
                '}';
    }
}
