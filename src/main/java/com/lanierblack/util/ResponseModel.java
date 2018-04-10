package com.lanierblack.util;


import com.lanierblack.common.Constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseModel<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7270365802060476881L;

    private Integer code;

    private Object data;

    private String msg;


    public ResponseModel(Integer code, Object data){
        this.code = code;
        this.data = data;
        this.msg = Constant.SUCCESS_MSG;
    }

    public ResponseModel(Integer statusCode, Object data, String msg){
        this(statusCode, data);
        this.setMsg(msg);
    }

    public ResponseModel(Integer statusCode, String msg){
        this(statusCode, new ArrayList<T>());
        this.setMsg(msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setStatusCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}