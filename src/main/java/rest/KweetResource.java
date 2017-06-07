/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Kweet;
import model.User;
import service.kwetterService;

/**
 *
 * @author saya
 */
@Path("/kweet")
@PermitAll
public class KweetResource
{
    
    @EJB
    kwetterService kwetterService;

    @GET 
    @Path("/testKweet")
    @Produces(MediaType.APPLICATION_JSON)
    public Kweet testKweet()
    {   
        //Kweet k = new Kweet("kpoe");
        Kweet k = new Kweet("leuk", new User("Saya"));
        //return k.getMessage();
        return k;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> listAllKweets() {
        List<Kweet> kweets = kwetterService.findAllKweets();
        for(Kweet k : kweets)
        {
            JSONPrep.prepToKweetforJson(k);
        }
        //JSONPrep.prepToUserForJson(user);
        return kweets;
    }
    
    @GET
    @Path("/recent/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> listRecentKweets(@PathParam("username") String username) {
        List<Kweet> kweets = kwetterService.getTop10Kweets(username);
        for(Kweet k : kweets)
        {
            JSONPrep.prepToKweetforJson(k);
        }
        //JSONPrep.prepToUserForJson(user);
        return kweets;
    }
    
    @GET
    @Path("/all/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> listAllFromUser(@PathParam("username") String username) 
    {
        List<Kweet> kweets = kwetterService.getAllKweets(username);
        for(Kweet k : kweets)
        {
            JSONPrep.prepToKweetforJson(k);
        }
        //JSONPrep.prepToUserForJson(user);
        return kweets;
    }

    @GET
    @Path("search/{kweetText}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kweet> getKweetsByContent(@PathParam("kweetText") String kweetText) 
    {
        List<Kweet> kweets = kwetterService.getKweetByText(kweetText);
        for(Kweet k : kweets)
        {
            JSONPrep.prepToKweetforJson(k);
        }
        return kweets;
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean createKweet(@FormParam("username") String username, @FormParam("message") String message) 
    {
        Kweet kweet = new Kweet(message, kwetterService.findByUserName(username));
        kwetterService.createKweet(kweet);
        
        return true;
    }
}
