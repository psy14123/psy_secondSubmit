package cn.psy.service.imp;

import cn.psy.dao.CodeDao;
import cn.psy.pojo.Code;
import cn.psy.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class CodeServiceImp implements CodeService {
    @Autowired
    CodeDao codeDao;
    //判断改手机号是否已经在数据库中
    @Override
    public Code queryCode(String tel) {
        return codeDao.queryCode(tel);
    }

    //如果用户手机号不存在，将手机号、验证码，及获取验证码生成的时间存入数据库
    @Override
    public int insertCode(String tel, String code, Date sendCodeTime) {
        return codeDao.insertCode(tel,code,sendCodeTime);
    }

    //如果用户手机号已经存在，将手机号、验证码，及获取验证码生成的时间更新存入数据库
    @Override
    public int updateCode(String tel, String code, Date sendCodeTime) {
        return codeDao.updateCode(tel,code,sendCodeTime);}
}
