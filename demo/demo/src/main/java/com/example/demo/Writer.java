package com.example.demo;
//Here we create one class and for this we access using setter constructor and field injection this is for one
// class we manually do but for large code we only want modify not edit the code in this it is difficult so it
// is achieved using polymorphism (interface) we create interface class and put the method and inside
// the interface we put primary to understand which class method to execute if more than one class
// contain primary use qualifier("class name ")

public interface Writer {
    void write();
}
