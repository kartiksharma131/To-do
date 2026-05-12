package com.todoapp.crud.todoapp.service;

import com.todoapp.crud.todoapp.models.ToDo;
import com.todoapp.crud.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void createToDoList(){
        toDoRepository.createTodoList();
    }

    public List<ToDo> getAllTodos(){
        return toDoRepository.getAllTodo();
    }

    public ToDo addToDo(ToDo todo){
        ToDo Newtodo = new ToDo();
        Newtodo.setId(todo.getId());
        Newtodo.setTitle(todo.getTitle());
        Newtodo.setStatus(todo.getStatus());
        Newtodo.setContent(todo.getContent());
        toDoRepository.SaveToDo(Newtodo);
        return Newtodo;
    }

    public ToDo getToDoByID(int id){

        return toDoRepository.getToDo(id);
    }

    public boolean isToDoAvailabe(int toDoid){
        List<ToDo> toDoList = toDoRepository.getAllTodo();
        if(toDoList.size()==0){
            return false;
        }
        return true;
    }

    public void updateToDo(int id , ToDo todo){

        toDoRepository.updateToDo(id,todo);
    }

    public void deleteToDo(int id){
        toDoRepository.deleteToDo(id);
    }
}
