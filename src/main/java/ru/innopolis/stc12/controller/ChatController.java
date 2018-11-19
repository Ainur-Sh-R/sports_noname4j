package ru.innopolis.stc12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

    @RequestMapping(value = "/chat")
    String showChat(Model model) {
        return "chat";
    }

    @RequestMapping(value = "/newMessage12")
    public String showLoginForm1(
            @RequestParam(value = "message", required = false) String message,
            Model model) {
        System.out.println(message);
        model.addAttribute("messageResponce", "value resp");
        return "chat";
    }
}
