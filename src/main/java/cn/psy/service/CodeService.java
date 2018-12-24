package cn.psy.service;

import cn.psy.pojo.Code;

import java.util.Date;

public interface CodeService {
    //判断改手机号是否已经在数据库中
    public Code queryCode(String tel);

    //如果用户手机号不存在，将手机号、验证码，及获取验证码生成的时间存入数据库
    public  int insertCode(String tel, String code, Date sendCodeTime);

    //如果用户手机号已经存在，将手机号、验证码，及获取验证码生成的时间更新存入数据库
    public  int updateCode(String tel, String code, Date sendCodeTime);
}
