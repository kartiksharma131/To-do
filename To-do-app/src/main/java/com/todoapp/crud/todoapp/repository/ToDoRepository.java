package com.todoapp.crud.todoapp.repository;

import com.todoapp.crud.todoapp.models.Status;
import com.todoapp.crud.todoapp.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private ToDo toDo;

    public void createTodoList(){

        String createToDoTable = "CREATE TABLE IF NOT EXITS todo (id INT PRIMARY KEY, title VARCHAR(255), content TEXT, status VARCHAR(50))";
        jdbcTemplate.execute(createToDoTable);
    }
    //save Todo
    public ToDo SaveToDo(ToDo toDo){
        String insertToDo = "INSERT INTO todo (id, title, content, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertToDo, toDo.getId(), toDo.getTitle(), toDo.getContent(), toDo.getStatus().toString());
        return toDo;
    }

    public ToDo getToDo(int id){
        String getTodo = "Select * from todo where id=?";
        ToDo toDobyid = jdbcTemplate.queryForObject(getTodo, new Object[]{id}, (rs, rowNum) -> {
            ToDo toDo = new ToDo();
            toDo.setId(rs.getInt("id"));
            toDo.setTitle(rs.getString("title"));
            toDo.setContent(rs.getString("content"));
            toDo.setStatus(Status.valueOf(rs.getString("status")));
            return toDo;
        });
        return toDobyid;
    }

    public List<ToDo> getAllTodo(){
        String getAllTodo = "Select * from todo";
        List<ToDo> toDoList = jdbcTemplate.query(getAllTodo, (rs, rowNum) -> {
            ToDo toDo = new ToDo();
            toDo.setId(rs.getInt("id"));
            toDo.setTitle(rs.getString("title"));
            toDo.setContent(rs.getString("content"));
            toDo.setStatus(Status.valueOf(rs.getString("status")));
            return toDo;
        });
        return toDoList;
    }

    public void deleteToDo(int id){
        String deleted = "DELETE FROM todo WHERE  id=?";
        jdbcTemplate.update(deleted, id);
    }

    public void updateToDo(int id, ToDo toDo){
        String updateToDo = "UPDATE todo SET title=?, content=?, status=? WHERE id=?";
        jdbcTemplate.update(updateToDo, toDo.getTitle(), toDo.getContent(), toDo.getStatus().toString(), id);

    }

}
