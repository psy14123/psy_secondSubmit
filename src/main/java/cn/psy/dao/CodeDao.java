package cn.psy.dao;

import cn.psy.pojo.Code;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface CodeDao {
    //查看验证码是否已经存在
    public Code queryCode(String tel);

    //没有验证码，便向数据库中插入一条
    public int insertCode(@Param("tel") String tel, @Param("code") String code, @Param("sendCodeTime") Date sendCodeTime);

    //若已经有验证码，更新验证码
    public int updateCode(@Param("tel") String tel, @Param("code") String code, @Param("sendCodeTime") Date sendCodeTime);

}
