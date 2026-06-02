package com.example.FastAPI.service;

import org.springframework.stereotype.Service;

@Service
public class helloService {

    public String greeting() {
        return "from helloservice";
    }

    public String lecture() {
        return "from helloservice !!";
    }
}
