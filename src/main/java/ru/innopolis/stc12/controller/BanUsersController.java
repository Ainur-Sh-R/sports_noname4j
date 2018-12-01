package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.bd.pojo.User;
import ru.innopolis.stc12.service.ServiceBanUsers;

import java.util.List;

@Controller
public class BanUsersController {
    ServiceBanUsers serviceBanUsers;

    @Autowired
    public void setServiceBanUsers(ServiceBanUsers serviceBanUsers) {
        this.serviceBanUsers = serviceBanUsers;
    }

    @RequestMapping(value = "/usersban")
    String showBanUsersForm(Model model){
        return "usersban";
    }

//    @RequestMapping(value = "/main")
//    String showMain(Model model){
//        return "main";
//    }

    @RequestMapping(value = "/banUser", method = RequestMethod.POST)
    public void banUser(@RequestParam (value = "userBanId") Integer userId) {
        serviceBanUsers.banUser(userId);
    }

    @RequestMapping(value = "/banUserCancel", method = RequestMethod.POST)
    public void banUserCancel(@RequestParam (value = "userBanId") Integer userId) {
        serviceBanUsers.banUserCancel(userId);
    }

    @RequestMapping("userlist")
    public void showUserList() {
        List<User> userList = serviceBanUsers.getUsers();

    }

}
