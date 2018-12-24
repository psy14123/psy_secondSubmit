package cn.psy.service.imp;

import cn.psy.dao.MessageDao;
import cn.psy.pojo.Message;
import cn.psy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    MessageDao messageDao;

    @Override
    public ArrayList<Message> queryMessage() {
        return messageDao.queryMessage();
    }

    @Override
    public Message queryMessageById(int temp_id) {
        return messageDao.queryMessageById(temp_id);
    }

    @Override
    public int editMessage(int id, String title, String date, String message) {
        return messageDao.editMessage(id,title,date,message);
    }

    @Override
    public int deleteMessage(int temp_id) {
        return messageDao.deleteMessage(temp_id);
    }

    @Override
    public int addMessage(String title, String message, String date) {
        return messageDao.addMessage(title,message,date);
    }
}
