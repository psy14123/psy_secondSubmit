package cn.psy.dao;

import cn.psy.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface MessageDao {
    //查询所有信息
    public ArrayList<Message> queryMessage();

    //查询一个消息，将该消息内容展示出到一个页面用于编辑
    public Message queryMessageById(int temp_id);

    //编辑消息
    public  int editMessage(@Param("id") int temp_id, @Param("title") String title, @Param("date") String date, @Param("message") String message);

    //删除消息
    public  int deleteMessage(int temp_id);

    //添加消息
    public  int addMessage(@Param("title") String title,@Param("message") String message,@Param("date") String date);
}
