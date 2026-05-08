package com.todoapp.crud.todoapp.service;

import com.todoapp.crud.todoapp.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private List<ToDo> toDoList;

    public void createToDoList(){
        toDoList = new ArrayList<>();
    }

    public List<ToDo> getAllTodos(){
        return toDoList;
    }

    public ToDo addToDo(ToDo todo){
        ToDo Newtodo = new ToDo();
        Newtodo.setId(todo.getId());
        Newtodo.setTitle(todo.getTitle());
        Newtodo.setStatus(todo.getStatus());
        Newtodo.setContent(todo.getContent());
        toDoList.add(Newtodo);
        return Newtodo;
    }

    public ToDo getToDoByID(int id){

        for(ToDo t: toDoList){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public boolean isToDoAvailabe(int toDoid){
        boolean exists = false;
        for(ToDo t: toDoList){
            if(t.getId() == toDoid){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void updateToDo(int id , ToDo todo){
        for(ToDo t : toDoList){
            if(t.getId()==id){
                t.setStatus(todo.getStatus());
                t.setContent(todo.getContent());
                t.setTitle(todo.getTitle());
            }
        }
    }

    public void deleteToDo(int id){
        for(int i=0;i<toDoList.size();i++){
            if(toDoList.get(i).getId()==id){
                toDoList.remove(i);
                break;
            }
        }
    }
}
