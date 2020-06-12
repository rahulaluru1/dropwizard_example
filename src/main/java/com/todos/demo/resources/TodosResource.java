package com.todos.demo.resources;


import com.todos.demo.services.TodosService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
