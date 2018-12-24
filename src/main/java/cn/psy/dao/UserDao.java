package cn.psy.dao;

import cn.psy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //在登陆时验证用户是否存在。
    public User queryUser(@Param("user") User user);

    //注册时查询表中是否已经存在该用户
    public User registerQueryUser(@Param("tel") String tel);

    //注册用户
    public int registerUser(@Param("tel") String tel,@Param("password") String password);

    //根据电话查询用户是否存在
    public User queryUserByTel(@Param("tel") String tel);
}
