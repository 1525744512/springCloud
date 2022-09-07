package com.example.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult<T> implements Serializable {
    private static final long serialVersionUID = 7555560156188442790L;
    private Integer code;
    private String msg;
    private Integer total;
    private T data;

    public AjaxResult(Integer code, String msg){
        this(code,msg,0,null);
    }
    public AjaxResult(Integer code, String msg, T data){
        this(code,msg,0,data);
    }

}