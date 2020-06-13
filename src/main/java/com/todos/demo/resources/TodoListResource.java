package com.todos.demo.resources;


import com.todos.demo.model.Todo;
import com.todos.demo.model.TodoList;
import com.todos.demo.services.TodoListService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/todolists")
@Consumes(MediaType.APPLICATION_JSON+"; charset=utf-8")
@Produces(MediaType.APPLICATION_JSON)
public class TodoListResource {
    private TodoListService todoListService;
    public TodoListResource(final TodoListService todoListService){
        this.todoListService=todoListService;
    }

    @GET
    public Response getTodoLists(){
        return Response.ok().entity(this.todoListService.getTodoLists()).build();
    }

    @GET
    @Path("{todolist_id}")
    public  Response getTodoList(@PathParam("todolist_id") final int todolist_id){
        return Response.ok().entity(todoListService.getTodoList(todolist_id)).build();
    }
//    @POST
//    @Path("/add")
//    public Response addTodoList(final @NotNull TodoList todoList){
//        this.todoListService.addTodoList(todoList);
//        return Response.ok().build();
//    }

    @PUT
    @Path("/edit/{id}")
    public  Response editTodoList(final @NotNull TodoList todoList, @PathParam("id") final int id){
        todoList.setId(id);
        return  Response.ok().entity(this.todoListService.editTodoList(todoList)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteTodoList(@PathParam("id") final int id){
        return Response.ok().entity(this.todoListService.deleteTodoList(id)).build();
    }
}