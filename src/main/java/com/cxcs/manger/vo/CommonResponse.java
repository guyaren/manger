package com.cxcs.manger.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
    private String code;
    private String result;
    private T data;
    private String orderId;
//    public static final String CODE_SUCCESS="200";
//    public static final String CODE_FAILED="500";


    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", result='" + result + '\'' +
                ", data=" + data +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public static<U> CommonResponse<U> buildSuccess(U data){
        CommonResponse<U> response = new CommonResponse<>();
        response.setCode(CodeMapping.SUCCESS);
        response.setResult("Success");
        response.setData(data);
        return response;
    }

    public static CommonResponse buildFailed(String data){
        CommonResponse response = new CommonResponse<>();
        response.setCode(CodeMapping.INNER_ERROR);
        response.setResult("Failed");
        response.setData(data);
        return response;
    }
}
