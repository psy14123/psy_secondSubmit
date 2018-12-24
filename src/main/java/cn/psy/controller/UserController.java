package cn.psy.controller;

import cn.psy.pojo.Code;
import cn.psy.pojo.Login;
import cn.psy.pojo.User;
import cn.psy.service.CodeService;
import cn.psy.service.LoginService;
import cn.psy.service.UserService;

import cn.psy.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 用来存放user相关的控制
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @Resource
    @Autowired
    private LoginService loginService;

    @Autowired
    private CodeService codeService;


    /**
     * 去往登陆界面
     *
     * @return String
     */
    @RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }


    /**
     * 去往注册界面
     *
     * @return String
     */
    @RequestMapping("/toregister")
    public String toRegister() {
        return "register";
    }


    /**
     * 用来判断登陆相关
     *
     * @param tel
     * @param password
     * @param request
     * @return String
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value = "tel") String tel, @RequestParam(value = "password") String password,
                        HttpServletRequest request) {

        User user = new User();
        user.setTel(tel);
        password = MD5Utils.getMD5(password);
        user.setPassword(password);   //将用户输入的tel和password存入user中以方便后面判断


        User unconfirmed_User = userService.queryUser(user); //判断用户是否在user表里，如果User不为空，则账号密码在数据库中有相应的匹配，即用户存在
        User unconfirmedRegister_User = userService.registerQueryUser(tel); //判断用户是否在user数据库里，在注册时确认
        Login unconfirmedLogin_User = loginService.queryUser(tel);//判断错误登陆三次锁定的表login中是否已经有这个账户

        Date errorLoginTime = new Date();//记录用户当前登陆的时间

        if (null == unconfirmedLogin_User) {
            loginService.insertUser(tel, errorLoginTime, -1);//login表和user表没有设置关联，如果user表中存在该用户而login表中不存在，则将其添加进去。
            unconfirmedLogin_User = loginService.queryUser(tel);
        }

        int count = unconfirmedLogin_User.getCount();//记录用户登录次数
        System.out.println("count" + count);
        Date lastLoginTime = unconfirmedLogin_User.getTime();//上次登录时间
        long result = errorLoginTime.getTime() - lastLoginTime.getTime();


        if (result > 180000)
            count = 0;
        if (null != unconfirmed_User) {      //数据库里已经存在手机号为tel的用户

            if (count > 2)//连续错误登陆次数已经超过三次
            {
                String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"三分钟内只允许登陆三次！\"}";
                loginService.updateUser(tel, errorLoginTime, count + 1);
                return jsonStr;
            } else {
                if ((null != unconfirmedLogin_User)) {        //用户存在但密码输入错误，那么输出密码输入错误，并且如果当前和上次错误时间相隔不到1分钟则count+1;
                    String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您将等待三分钟！\"}";
                    loginService.updateUser(tel, errorLoginTime, count + 1);
                    return jsonStr;
                } else {                 //登陆成功

                    loginService.updateUser(tel, errorLoginTime, 0);
                    HttpSession session = request.getSession();
                    session.setAttribute("rs_user", unconfirmed_User);
                    String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
                    return jsonStr;
                }
            }
        } else {    //该数据库没有存储过该tel
            loginService.insertUser(tel, errorLoginTime, 1);
            loginService.updateUser(tel, errorLoginTime, count + 1);
            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
            return jsonStr;
        }
    }

    /**
     * 注册验证相关
     *
     * @param tel
     * @param clientCode
     * @param password
     * @param request
     * @return String
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam(value = "tel") String tel, @RequestParam(value = "code") String clientCode, @RequestParam(value = "password") String password, HttpServletRequest request) {

        Code codeBean = codeService.queryCode(tel);
        String serverCode = codeBean.getCode();  //取到后台正确的验证码
        System.out.println(serverCode);
        User user = userService.registerQueryUser(tel);


        if (!clientCode.equals(serverCode) || null == serverCode) {

            String jsonStr = "{\"errorCode\":\"2\",\"errorMessage\":\"验证码错误\"}";

            return jsonStr;
        } else {
            if (null == user) {//用户在注册表为空，即为新用户

                password = MD5Utils.getMD5(password);
                int result = userService.registerUser(password, tel);
                String jsonStr = "{\"errorCode\":\"1\",\"errorMessage\":\"success\"}";

                return jsonStr;
            } else {

                String jsonStr = "{\"errorCode\":\"0\",\"errorMessage\":\"phone or password is error\"}";
                return jsonStr;


            }
        }
    }


}






