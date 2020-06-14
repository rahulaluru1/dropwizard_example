package com.todos.demo.db;

import com.todos.demo.model.Todo;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TodosMapper.class)
public interface TodosDao {
    @SqlQuery("SELECT * FROM todos inner join todolist on todos.todolist_id=todolist.id")
    public List<Todo> getTodos();

    @SqlQuery("Select * from todos inner join todolist on todos.todolist_id=todolist.id where todo_id=:id")
    public Todo getTodo(@Bind("id") final int id);

    @SqlUpdate("INSERT into `todos` ( `todo_name`, `todo_description`, `todolist_id` )"+
               "VALUES ( :todo_name,:todo_description,:todolist_id)")
    public void addTodo(@BindBean Todo todo);

    @SqlUpdate("update todos set todo_name=coalesce(:todo_wname,todo_name), todo_description=coalesce(:todo_description,todo_description) where todo_id= :todo_id")
    void editTodo(@BindBean Todo todo);

    @SqlUpdate("delete from todos where todo_id= :id")
    int deleteTodo(@Bind("id") final int id);
}
