package cn.fjut.gmxx.utils;

import lombok.Data;

/**
 */
public class R {
    public static final int OK = 200;
    public static final int ERROR = 100;
    public static final int NO_LOGIN = 101;
    public static final int WARN = 300;
    private int code;
    private String msg;
    private Object data;

    public R() {
        super();
    }

    public R(Object data) {
        super();
        this.data = data;
    }

    public R(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public static int getOK() {
        return OK;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getNoLogin() {
        return NO_LOGIN;
    }

    public static int getWARN() {
        return WARN;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
