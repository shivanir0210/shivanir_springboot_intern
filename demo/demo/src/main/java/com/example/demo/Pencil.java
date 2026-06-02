package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier("Pencil")
public class Pencil implements Writer{
    public void write()
    {
        System.out.println("this is write from pencil class write method");
    }
}
