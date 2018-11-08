package ru.innopolis.stc12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc12.bd.pojo.User;
import ru.innopolis.stc12.service.ServiceUsers;

@Controller
public class UserController {

    ServiceUsers serviceUsers;

    @Autowired
    public void setServiceUsers(ServiceUsers serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        model.addAttribute("loginError", error);
        return "login";
    }

    @RequestMapping(value = "/registr", method = RequestMethod.GET)
    public String showRegistrForm(Model model) {
        return "registr";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(
            @RequestParam(value = "userLogin") String login,
            @RequestParam(value = "userPassword") String password,
            Model model) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        serviceUsers.registration(user);
        return "registr";
    }

}
