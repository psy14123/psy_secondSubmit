package cn.psy.service;

import cn.psy.pojo.Message;

import java.util.ArrayList;

public interface MessageService {
    //查询所有信息
    public ArrayList<Message> queryMessage();

    //查询一个消息，将该消息内容展示出到一个页面用于编辑
    public Message queryMessageById(int temp_id);

    //编辑消息
    public  int editMessage(int id,String title,String date,String message);

    //删除消息
    public  int deleteMessage(int temp_id);

    //添加消息
    public  int addMessage(String title,String message,String date);
}
