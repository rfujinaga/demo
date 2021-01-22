package com.example.demo.web.controller;

import com.example.demo.domain.dao.UserDao;
import com.example.demo.domain.dao.entity.User;
import com.example.demo.web.form.SampleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Thymeleafcontroller {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg1", "HelloWorld");
        model.addAttribute("sampleForm", new SampleForm());
        return "index";
    }

    //    @PostMapping("/")
//    public String send(@RequestParam("text1") String txt,Model model){
//        model.addAttribute("msg",txt);
//        return "result";
//    }
    @PostMapping("/")
    public String send(@Validated SampleForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "index";
        }
        model.addAttribute("resultForm", form);
        User user = new User();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());
        user.setEmailAddress(form.getEmailAddress());
        user.setPassword(form.getPassword());
        userDao.insert(user);
        return "/result";
    }
}

