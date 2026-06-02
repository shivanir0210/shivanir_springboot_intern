package com.eduhub.eduhub_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class helloworldcontroller {

    private final Environment environment;
    @Value("${spring.application.name}")
    private String appName;
    public helloworldcontroller(Environment environment) {
        this.environment = environment;
    }
    @GetMapping("hello-world")
    public String helloWorld(){
        return "hello world";
    }
    @GetMapping("/env")
        public String getEnvironmentVaraibles()
        {
            String port=environment.getProperty("server.port");
            return "app Name : " +appName+ "Port : "+port;

        }


}
