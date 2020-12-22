package com.mzll.test.aliyunn.controller;

import com.mzll.test.aliyunn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @Autowired
    private VideoService service;

    @RequestMapping("/test")
    public Object uploadVideo(@RequestParam("title") String title, @RequestParam("name") String fileName) {
//        title = "123123";
//        fileName = "C:/Users/mzll/Music/MV/林俊杰-将故事写成我们(标清).mp4";
        return service.uploadVideo(title, fileName);

    }

    @RequestMapping("/play/{videoId}")
    public Object play(@PathVariable("videoId")String id) throws Exception {
        return service.getPlayInfo(id);
    }
}
