package com.demo.cloud.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


/**
 * @author Batman.qin
 */
public class BaseResponse<T> implements Serializable {
    @JsonProperty(value = "Status")
    private String Status;
    @JsonProperty(value = "StatusCode")
    private String StatusCode;
    @JsonProperty(value = "Msg")
    private String Msg;
    @JsonProperty(value = "Timestamp")
    private String Timestamp;
    @JsonProperty(value = "Sign")
    private String Sign;
    @JsonProperty(value = "Result")
    private T Result;

    @JsonIgnore
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @JsonIgnore
    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    @JsonIgnore
    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    @JsonIgnore
    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    @JsonIgnore
    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    @JsonIgnore
    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }

    public static <T> BaseResponse<T> successResponse(T result) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setStatusCode("200");
        response.setStatus("true");
        response.setMsg("成功");
        response.setResult(result);
        return response;
    }

    public static BaseResponse errorResponse() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode("500");
        response.setStatus("false");
        response.setMsg("失败");
        response.setResult("0");
        return response;
    }

    public static <T> BaseResponse<T> exceptionResponse(String code, T message) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(code);
        response.setStatus("false");
        response.setMsg(message.toString());
        response.setResult(message);
        return response;
    }

}
