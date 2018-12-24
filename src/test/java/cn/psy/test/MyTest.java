package cn.psy.test;


import cn.psy.pojo.Message;
import cn.psy.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)//固定写法
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/*.xml"})//spring与mybatis整合的配置文件
//  ******  mmp 警告***** 测试里如果不加Transactional，对数据库的成功操作都会相应地更改数据库，加上后，即使成功也不会修改数据库里的值
@Transactional
public class MyTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void test01(){
        messageService.addMessage("title666","content","2018-12-16 16:34:00");
    }

    @Test
    public void test02(){
        List<Message> list=messageService.queryMessage();
        for(Message temp:list){
            System.out.println("ID:"+temp.getId()+";Title:"+temp.getTitle()+";date:"+temp.getDate()+";content:"+temp.getMessage());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(list.size());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
