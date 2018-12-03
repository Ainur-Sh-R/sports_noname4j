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

    @RequestMapping(value = "/usersban", method = RequestMethod.GET)
    String showUserBanList(Model model){
        model.addAttribute("userlist", serviceBanUsers.getUsers());
        return "usersban";
    }

    @RequestMapping(value = "/banUser", method = RequestMethod.POST)
    public String banUser(@RequestParam (value = "userBanId") Integer userId) {
        serviceBanUsers.banUser(userId);
      return "usersban";
    }

    @RequestMapping(value = "/banUserCancel", method = RequestMethod.POST)
    public String banUserCancel(@RequestParam (value = "userBanId") Integer userId) {
        if (userId != null) {
            serviceBanUsers.banUserCancel(userId);
        }
      return "usersban";
    }

}
