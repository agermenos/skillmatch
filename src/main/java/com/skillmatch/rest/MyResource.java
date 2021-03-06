package com.skillmatch.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new MyResponse("You're the best!", "Who's the best", "By Myself"));
    }
}

class MyResponse {
    String response;
    String title;
    String footer;

    public MyResponse(String response, String title, String footer) {
        this.response = response;
        this.title = title;
        this.footer = footer;
    }
}
