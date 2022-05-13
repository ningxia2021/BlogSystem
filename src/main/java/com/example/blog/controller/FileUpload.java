package com.example.blog.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Data
@NoArgsConstructor //生成无参构造函数
@AllArgsConstructor //生成全参数构造函数
class Message {
    //0表示成功;-1表示失败
    int status;
    //向前端返回的内容
    String massage;

}
@RestController
public class FileUpload {

    @PostMapping("/upload")
//    形参fileUpload 为表单中图片名称的key  也就是name属性定义的名称
    public Object uploadImg(@RequestParam("fileUpload") MultipartFile file) {
//        获取文件名
        String fileName = file.getOriginalFilename();
//        获取文件后缀名
        String suffixName  = fileName.substring(fileName.lastIndexOf("."));
//        重新生成文件名
        String newFileName =  UUID.randomUUID() + suffixName;
//        指定本地文件夹存储图片，写到需要保存的目录下
        String filePath = "P:\\SpringBootStudy\\BlogSystem\\src\\main\\resources\\static\\img\\";
        try {
            file.transferTo(new File(filePath + newFileName));
            return new Message(0,"上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Message(-1,"上传失败");
        }
    }

}
