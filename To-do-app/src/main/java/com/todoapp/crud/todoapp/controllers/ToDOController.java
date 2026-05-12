package com.todoapp.crud.todoapp.controllers;

import com.todoapp.crud.todoapp.models.ToDo;
import com.todoapp.crud.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDOController {

    @Autowired
    ToDoService toDoService;

    @PostMapping("/create")
    public ResponseEntity<String> createTodo() {
        toDoService.createToDoList();
        ResponseEntity<String> response = ResponseEntity.ok("ToDo List created successfully");
        return response;
    }

    @GetMapping("/getAllToDos")
    public ResponseEntity<List<ToDo>> getAllToDos(){
        List<ToDo> list= toDoService.getAllTodos();

        ResponseEntity<List<ToDo>> response = ResponseEntity.ok(list);
        return response;
    }

    @PostMapping("/addToDo")
    public ToDo addToDo(@RequestBody ToDo toDo){
        ToDo newTodo = toDoService.addToDo(toDo);
        return newTodo;
    }

    @GetMapping("/getToDoByID")
    public ToDo getToDoByID(@RequestParam("id") int id ){
        ToDo todo = toDoService.getToDoByID(id);
        return todo;
    }

    @PutMapping("/update/{id}")
    public ToDo updateToDo( @PathVariable("id") int id , @RequestBody ToDo todo){
        boolean isToDoInList = toDoService.isToDoAvailabe(todo.getId());
        if(!isToDoInList){
            ToDo newTodo = toDoService.addToDo(todo);
            return newTodo;
        }
        toDoService.updateToDo(id, todo);
        return toDoService.getToDoByID(id);
    }

    @DeleteMapping("/deleteToDo/{id}")
    public String deleteToDo(@PathVariable int id){
        boolean isToDoInList = toDoService.isToDoAvailabe(id);
        if(!isToDoInList){
            return "ToDo not present in the list";
        }
        toDoService.deleteToDo(id);
        return ("Todo delete successfully!!!");
    }
}
