package com.todos.demo.db;

import com.todos.demo.model.Todo;
import com.todos.demo.model.TodoList;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TodoListMapper.class)
public interface TodoListDao {
    @SqlQuery("SELECT * FROM todolist")
    public List<TodoList> getTodoLists();

    @SqlQuery("SELECT * from todolist where id= :todolist_id")
    public TodoList getTodoList(@Bind("todolist_id") final int todolist_id);
    @SqlUpdate("update todolist set name=coalesce(:name,name), description=coalesce(:description,description) where id= :id")
    void editTodoList(@BindBean  TodoList todoList);

    @SqlUpdate("delete from todolist where id= :id")
    int deleteTodoList(@Bind("id") final int id);

//    @SqlQuery("INSERT into `todolist` ( `name`, `description`)"+
//            "VALUES ( :name,:description)")
//    public  void addTodoList(@BindBean TodoList todoList);

}
