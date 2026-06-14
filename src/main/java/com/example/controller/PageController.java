package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Help Desk");
        model.addAttribute("welcomeMessage", "Добро пожаловать ^-^");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "О нас");
        model.addAttribute("teamName", "Учебная команда Help Desk");
        model.addAttribute("description", "Мы создаём учебную систему для обработки обращений.");
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageTitle", "Контакты поддержки");
        model.addAttribute("supportEmail", "helpdesk@mail.ru");
        model.addAttribute("workTime", "Пн-Пт, 10:00-22:00");
        model.addAttribute("phone", "+7 (777) 77-77-77");
        return "contacts";
    }
}