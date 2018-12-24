package cn.psy.service.imp;

import cn.psy.dao.UserDao;
import cn.psy.pojo.User;
import cn.psy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User queryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public User queryUserByTel(String tel) {
        return userDao.queryUserByTel(tel);
    }

    @Override
    public User registerQueryUser(String tel) {
        return userDao.registerQueryUser(tel);
    }

    @Override
    public int registerUser(String tel, String password) {
        return userDao.registerUser(tel, password);
    }
}
