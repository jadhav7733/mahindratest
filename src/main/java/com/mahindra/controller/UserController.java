package com.mahindra.controller;

import com.mahindra.entity.GetResponse;
import com.mahindra.entity.Response;
import com.mahindra.entity.User;
import com.mahindra.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveUser(@Valid @RequestBody User user)
    {
        User user1 =  userService.saveUser(user);
        if(user1==null)
        {
            Response response = new Response("error","Lead Already Exists in the database with the lead id");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
        {
            Response response = new Response("success","Created Leads Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    @GetMapping("/byMobileNumber/{no}")
    public ResponseEntity<Object> saveUser (@PathVariable("no") String no)
    {
        List<User> users =  userService.findByMobNo(no);
        if(users==null)
        {
            Response response = new Response("error","No Lead found with the Mobile Number ");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
        {
            GetResponse response = new GetResponse();
            response.setMessage("success");
            response.setData(users);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
    }
}
