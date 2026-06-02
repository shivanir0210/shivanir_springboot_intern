package com.example.FastAPI.controller;

import com.example.FastAPI.service.helloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    helloService s;
@GetMapping("/get")
    public String greet()
{
    return s.greeting();
}
@GetMapping("/about/lecture")
    public String lec()
{
  return s.lecture();
}

}
