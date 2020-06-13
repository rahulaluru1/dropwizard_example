package com.todos.demo.resources;


import com.todos.demo.model.Todo;
import com.todos.demo.services.TodosService;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/todos")
@Consumes(MediaType.APPLICATION_JSON+"; charset=utf-8")
@Produces(MediaType.APPLICATION_JSON)
public class TodosResource {
    private TodosService todosService;

    public TodosResource(final TodosService todosService){
        this.todosService=todosService;
    }
    @GET
    public Response getTodos(){
        return Response.ok().entity(this.todosService.getTodos()).build();
    }

    @GET
    @Path("{todo_id}")
    public Response getTodo(@PathParam("todo_id") final int todo_id){
        return Response.ok().entity(this.todosService.getTodo(todo_id)).build();
    }

    @POST
    @Path("/add")
    public Response addTodo(final @NotNull Todo todo){
        this.todosService.addTodo(todo);
        return Response.ok().build();
    }

    @PUT
    @Path("/edit/{id}")
    public  Response editTodo(final @NotNull Todo todo, @PathParam("id") final Long id){
        todo.setTodo_id(id);
        return  Response.ok().entity(this.todosService.editTodo(todo)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteTodo(@PathParam("id") final int id){
        return Response.ok().entity(this.todosService.deleteTodo(id)).build();
    }
}
