package com.hxuanyu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传下载
 * date 2021/9/9 8:10
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String path = servletContext.getRealPath("/static/img/1.jpg");
        // 创建输入流
        FileInputStream is = new FileInputStream(path);
        // 创建字节数组
        byte[] bytes = new byte[is.available()];
        // 将流读到字节数组中
        int read = is.read(bytes);
        System.out.println("读取了" + read + "字节");
        // 创建HttpHeaders对象设置响应头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置要下载的方式以及下载文件的名字
        httpHeaders.setContentDispositionFormData("attachment", "123.jpg");
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置响应状态码
        HttpStatus status = HttpStatus.OK;
        // 创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, status);
        // 关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile file, HttpSession session) throws IOException {
        System.out.println(file + ", " + session.toString());
        // 获取上传的文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        // 处理文件重名问题
        String hzName = null;
        if (fileName != null) {
            hzName = fileName.substring(fileName.lastIndexOf("."));
        }
        fileName = UUID.randomUUID() + hzName;
        // 获取服务器中file目录的路径
        ServletContext servletContext = session.getServletContext();
        String filePath = servletContext.getRealPath("file");
        File file1 = new File(filePath);
        if (!file1.exists()) {
            boolean success = file1.mkdir();
            if (success){
                System.out.println("创建文件夹"+filePath+"成功");
            }
        }
        String finalPath = filePath + File.separator + fileName;
        // 上传
        file.transferTo(new File(finalPath));
        return "success";
    }

}
