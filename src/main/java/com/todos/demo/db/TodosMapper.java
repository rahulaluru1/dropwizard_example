package com.todos.demo.db;

import com.todos.demo.model.Todo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodosMapper implements ResultSetMapper<Todo> {

    @Override
    public Todo map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        int todo_id=resultSet.getInt("todo_id");
        String todo_name=resultSet.getString("todo_name");
        String todo_description=resultSet.getString("todo_description")!=null ? resultSet.getString("todo_description") : "";
        int todolist_id=resultSet.getInt("todolist_id");
        int id=resultSet.getObject("id")!=null ? resultSet.getInt("id") : 0 ;
        String name=resultSet.getString("name")!=null ? resultSet.getString("name") : "";
        String description=resultSet.getString("description")!=null ? resultSet.getString("description") : "";
        Todo todo=new Todo(
                id,
                name,
                description,
                todo_id,
                todo_name,
                todo_description,
                todolist_id
        );

        return todo;
    }
}
