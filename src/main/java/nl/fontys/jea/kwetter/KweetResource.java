package nl.fontys.jea.kwetter;


import nl.fontys.jea.kwetter.Kweet;
import nl.fontys.jea.kwetter.User;
import java.util.Calendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saya
 */
@Path("/kweet")
public class KweetResource 
{
    
    @GET 
    @Path("/test1")
    @Produces(MediaType.APPLICATION_JSON)
    public Kweet testKweet()
    {   
        Kweet k = new Kweet("leuk", new User("Saya"), Calendar.getInstance());
        
        return k;
    }
//    public Response read(@PathParam("id")Long id)       
//    {
//        //testlol k = new testlol(1,"hello");
//        //Kweet k = new Kweet("Hallo", new User("Saya"), Calendar.getInstance());
//        
//        
//        //return Response.status(201).entity(k).build();
//    }

}
