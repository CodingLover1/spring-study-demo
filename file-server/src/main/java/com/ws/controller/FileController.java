package com.ws.controller;

import com.ws.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shuo.wang
 * @date 19-9-17
 */

@RestController()
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("upload")
    public String uploadFile(MultipartFile file){
        try{
           return  fileService.uploadFile(file);

        }catch (Exception e){
            return "failed";
        }
    }

    @GetMapping("download/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response){
        try{
            fileService.downloadFile(fileName,request,response);
        }catch (Exception e){

        }
    }

    @GetMapping("download2/{fileName}")
    public void downloadFile2(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response){
        try{
            fileService.downloadFile2(fileName,request,response);
        }catch (Exception e){

        }
    }
}
