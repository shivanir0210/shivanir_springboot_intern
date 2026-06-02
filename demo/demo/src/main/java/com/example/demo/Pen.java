package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
@Qualifier("Pencil")
public class Pen implements Writer {
    public void write()
    {
        System.out.println("this is from pen class write method");
    }
}
