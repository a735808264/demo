package com.example.demo.Controller;

import com.example.demo.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {

    @GetMapping("/basic_table")
    public String basicTable(){

        return "/table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamicTable(Model model){

/*        List<User> users = Arrays.asList(new User("zhangsan", "1234567"),
                new User("LIbai", "894654"),
                new User("mayun", "894asdas4"),
                new User("zhangxi", "g894daaw4"),
                new User("asdnsabf", "88g44654"),
                new User("asdkjasfwd", "8gg94zczxg654"));
        model.addAttribute("users",users);*/
        return "/table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsiveTable(){

        return "/table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editableTable(){

        return "/table/editable_table";
    }
}
