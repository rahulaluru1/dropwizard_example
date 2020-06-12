package com.todos.demo.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/greetings/{name}")
public class HelloWorldResource {
    @GET
    public String getGreeting(@PathParam("name") String name){
        return "hello "+name+"!";
    }
}
