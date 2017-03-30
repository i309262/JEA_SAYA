package rest;


import model.Kweet;
import model.User;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Role;
import service.kwetterService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saya
 */
@Path("/user")
//@Stateless
public class KweetResource
{
    //@Inject
    //kwetterService kwetterService;
    kwetterService kwetterService = new kwetterService();
    
    
    @GET 
    @Path("/testKweet")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Kweet testKweet()
    {   
        //Kweet k = new Kweet("kpoe");
        Kweet k = new Kweet("leuk", new User("Saya"));
        //return k.getMessage();
        return k;
    }
    
    @GET
    @Path("/all")
    public List<User> listAllUsers() {
//        User userSaya = new User("saya", "saya123", "Saya Laugs", "Ik ben Ik", "Eindhoven", "www.saya.nl");
//        User userHarry = new User("harry", "harry123", "Harry Harrison", "Ik ben Harry", "Eindhoven", "www.harry.nl");
//        kwetterService.createUser(userSaya);
//        kwetterService.createUser(userHarry);
        
        return kwetterService.findAllUsers();
    }
    
    @GET
    @Path("/{username}")
    public User getUser(@PathParam("username") String username){
        return kwetterService.findByUserName(username);
    }
    
    @GET
    @Path("/insert")
    public String insertUsers() {
        //saya
        User userSaya = new User("saya", "saya123", "Saya Laugs", "Ik ben Ik", "Eindhoven", "www.saya.nl");
        //Kweet kweetSaya = new Kweet("dit is een kweet", userSaya);
        //userSaya.addKweet(kweetSaya);
        //userSaya.setRole(Role.Moderator);
        kwetterService.createUser(userSaya);
        
        //harry
        User userHarry = new User("flakka", "harry123", "Harry Harrison", "Ik ben Harry", "Eindhoven", "www.harry.nl");
//        Kweet kweetHarry = new Kweet("dit is een kweet", userHarry);
//        userHarry.addKweet(kweetHarry);
//        userHarry.setRole(Role.User);
        kwetterService.createUser(userHarry);
        
        return "succesfully inserted users with kweets";

    }
    

    
//    @GET 
//    @Path("/getKweetByID")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Kweet getKweetByID()
//    {   
//        Kweet k = new Kweet("leuk", new User("Saya"), Calendar.getInstance());
//        
//        return k;
//    }
    
    
    
    
//    public Response read(@PathParam("id")Long id)       
//    {
//        //testlol k = new testlol(1,"hello");
//        //Kweet k = new Kweet("Hallo", new User("Saya"), Calendar.getInstance());
//        
//        
//        //return Response.status(201).entity(k).build();
//    }

}
