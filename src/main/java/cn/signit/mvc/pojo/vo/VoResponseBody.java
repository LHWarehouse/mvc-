package cn.signit.mvc.pojo.vo;

import java.util.List;

public class VoResponseBody<E> {
    private Integer status;// 响应业务状态
    private String msg;    // 响应消
    private List<E> data;  // 响应中的数据

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

}
