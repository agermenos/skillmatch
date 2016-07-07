package com.skillmatch.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by agermenos on 7/6/16.
 */

@Path("user/{userId}")
public class UserRest {
    @Autowired

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") int userId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return Response.status(200).entity(gson.toJson(new MyResponse("You're the best!", "Who's the best", "User " + userId))).build();
    }
}
