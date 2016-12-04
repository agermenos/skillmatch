package com.skillmatch.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skillmatch.pojos.User;
import com.skillmatch.services.CatalogService;
import com.skillmatch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by agermenos on 7/6/16.
 */

@Component
@Path("user/{userId}")
public class UserRest {
    @Autowired
    UserService userService;
    @Autowired
    CatalogService catalogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("userId") int userId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User user = userService.getUser(userId);
        return gson.toJson(user);
    }
}
