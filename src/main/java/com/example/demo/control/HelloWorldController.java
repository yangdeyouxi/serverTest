package com.example.demo.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文根,访问时就要多一层目录层级
@RequestMapping(value = "/test")
public class HelloWorldController {

    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        logger.info("1111:" );
        return "Hello World:" ;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(String userName){
        return "Hello World222:" + userName;
    }

    @RequestMapping(value = "/getJson",method = RequestMethod.POST)
    public String getJson(@RequestBody String body){
        return "getJson:" + body;
    }

}
