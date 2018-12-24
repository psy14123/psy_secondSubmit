package cn.psy.controller;

import cn.psy.dao.MessageDao;
import cn.psy.pojo.Message;
import com.mchange.v2.util.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageDao messageDao=null;

    //消息界面，查询所有消息展示在页面上

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/toMessage")
    public String toMessage(Model model){
        List<Message> list=messageDao.queryMessage();

            model.addAttribute("list",list);
            return "message";

    }

    //查询一个消息，将该消息内容展示出到一个页面用于编辑
    @RequestMapping("/Message")
    public String queryMessageById(@RequestParam("id") int temp_id){
        Message message=messageDao.queryMessageById(temp_id);
        return "edit";
    }

    //跳转到添加消息界面
    @RequestMapping("/toAddMessage")
    public String toAddMessage(){return "add";}

    //添加消息
    @RequestMapping("/addMessage")
    public String addMessage(String title,String message
            , String date){
        int rs=messageDao.addMessage(title,message,date);
        System.out.println("成功添加元素");
        return "redirect:/toMessage";
    }

    //跳转到编辑消息界面
    @RequestMapping("/toEditMessage")
    public String toDeleteMEssage(@RequestParam int id,Model model){
        Message message=messageDao.queryMessageById(id);
        System.out.println(message.toString());
        model.addAttribute("mes",message);
        return "edit";}

    //删除消息
    @RequestMapping("/deleteMessage")
    public  String  deleteMessage(@RequestParam ("id") int temp_id){
        System.out.println(temp_id);
        int rs=messageDao.deleteMessage(temp_id);

        return "redirect:/toMessage";
    }

    //编辑消息
    @RequestMapping("/editMessage")
    public  String editMessage(@RequestParam("id") int id,@RequestParam("title") String title,@RequestParam("date")
            String date,@RequestParam("message") String message){
        int rs=messageDao.editMessage(id,title,date,message);
        return "redirect:/toMessage";
    }
}