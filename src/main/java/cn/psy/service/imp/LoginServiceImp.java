package cn.psy.service.imp;

import cn.psy.dao.LoginDao;
import cn.psy.pojo.Login;
import cn.psy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    LoginDao loginDao;

    //查询login表中是否已经有过该用户错误登陆记录
    @Override
    public Login queryUser(String tel) {
        return loginDao.queryUser(tel);
    }

    //如果该用户没有错误登陆记录，表中没有他的数据，则向表中添加
    @Override
    public int insertUser(String tel, Date time, int count) {
        return loginDao.insertUser(tel,time,count);
    }

    //更新用户的错误登陆时间
    @Override
    public int updateUser(String tel,Date time,int count) {
        return loginDao.updateUser(tel,time,count);
    }
}
