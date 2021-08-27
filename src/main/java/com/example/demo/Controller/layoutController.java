package com.example.demo.Controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class layoutController {

    private static final Logger LOGGER = LoggerFactory.getLogger(layoutController.class);
    @GetMapping( "/from_layout")// @GetMapping("/basic_table")
   public String UpLoad(){

        return "/layout/form_layouts";
   }
   @RequestMapping(value = "/upload",method = RequestMethod.POST)
   public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()){
            model.addAttribute("msg1","请放入文件");
        }else
        {
            final String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("D:\\da",originalFilename));
            System.out.println("name:"+originalFilename);
            model.addAttribute("msg1","上传成功！");
        }
       return "/layout/form_layouts";
   }

}
