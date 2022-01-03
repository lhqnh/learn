package com.lhqs.boot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormsController {

    @RequestMapping("/form_layouts")
    public String form_layouts(){
        return "forms/form_layouts";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        //判断上传的文件是否为空，不是保存到磁盘
        if(headerImg.isEmpty()){
            //获取文件上传的源文件名
            String originalFilename = headerImg.getOriginalFilename();
            //将文件保存到D://Test目录下
            headerImg.transferTo(new File("D:\\Test\\"+originalFilename));
        }
        if(photos.length != 0){
            for (MultipartFile photo : photos){
                String originalFilename = photo.getOriginalFilename();
                photo.transferTo(new File("D:\\Test\\"+originalFilename));
            }
        }
        return "index";
    }
}
