package com.todoapp.crud.todoapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    @RequestMapping("/todos")
    public List<String> getTodos(){
        List<String> todo = Arrays.asList("Go to the gym", "Buy groceries", "Finish homework");
        return todo;
    }
}
