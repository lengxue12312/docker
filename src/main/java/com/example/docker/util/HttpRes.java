package com.example.docker.util;

import java.util.Objects;

public class HttpRes {
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpRes(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpRes httpRes = (HttpRes) o;
        return code == httpRes.code && msg.equals(httpRes.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg, code);
    }

    @Override
    public String toString() {
        return "HttpRes{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
