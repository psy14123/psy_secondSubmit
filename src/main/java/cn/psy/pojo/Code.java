package cn.psy.pojo;

import java.util.Date;

public class Code {
    private String tel;
    private Date sendCodeTime;
    private String code;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getSendCodeTime() {
        return sendCodeTime;
    }

    public void setSendCodeTime(Date sendCodeTime) {
        this.sendCodeTime = sendCodeTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
