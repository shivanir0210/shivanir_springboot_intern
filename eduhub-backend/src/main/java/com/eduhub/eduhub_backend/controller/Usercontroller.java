package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.User;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    static List<User> users=new ArrayList<>();
    static
    {
        users.add(new User("abc123","shiva","shiva123"));
        users.add(new User("2","abi","abisasi"));
        users.add(new User("3","aswin","aswin20"));
        users.add(new User("4","rithan","aadhi"));
        users.add(new User("5","subi","subi"));
    }
    @GetMapping("/get")
    public ResponseEntity<List<User>>getusers()
    {
        return ResponseEntity.ok(users);
    }
    @GetMapping("get/{userid}")
    public ResponseEntity<User> getUser(@PathVariable String  userid)
    {
        User user=users.stream().filter(u-> u.getUserid().equals(userid)).findFirst().orElseThrow(() ->
        new ResourceNotFoundException("user","userid",String.valueOf(userid)));
        return ResponseEntity.ok(user);
    }
    //use pathvaraible and request body to get user if contain special character throw illegal argument exception
    @GetMapping("specify/{userid}")
    public String getuserid(@PathVariable String userid)
    {
        if(userid.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("cant contain special character");
        }
        return userid;
    }
    @GetMapping("/param/{userid}")
    public String getuserbyquery(@RequestParam String userid)
    {
        if(userid.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("cant contain special character");
        }
        return userid;
    }
    //post new entries
    @PostMapping("/add")
    public ResponseEntity<List<User>> adduser(@RequestBody List<User> user)
    {
        users.addAll(user);
        return ResponseEntity.ok(user);
    }
    //update any one entry pass
    @PutMapping("/update/{password}")
    public ResponseEntity<List<User>> updateuser(@RequestBody List<User> user,@PathVariable String password)
    {
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("delete/{userid}")
    public ResponseEntity<String> deleteuser(
            @PathVariable String userid) throws Exception
    {
        User user = users.stream()
                .filter(u -> u.getUserid().equals(userid))
                .findFirst()
                .orElseThrow(() ->
                        new Exception("User not found")
                );

        users.remove(user);

        return ResponseEntity.ok("User deleted successfully");
    }
}
