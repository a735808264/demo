package com.example.demo.Controller;

import com.example.demo.Bean.Account;
import com.example.demo.Bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(value = {"/","/login"})
    public String Loginpage(){
        return "login";
    }
    @PostMapping("/login")
    public String mainPage(User user, HttpSession session, Model model, Response response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (!StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/index.xml";
       } else {
            model.addAttribute("msg","账号密码错误");
            return "login";

        }
    }
    @GetMapping("/index.xml")
    public String main(HttpSession session){
        session.getAttribute("loginUser");
        return  "/layout/form_layouts";
        //return "index";
    }
    @RequestMapping("/json")
    @ResponseBody
    public String json() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        Account account=new Account(15l,"xiami",58,"132131");
        String s = objectMapper.writeValueAsString(account);
        return s;
    }

}
