package rest;


import model.Kweet;
import model.User;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.ResponseWrapper;
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
    //@EJB
    @Inject
    kwetterService kwetterService;
    //kwetterService kwetterService = new kwetterService();
    
    
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAllUsers() {   
        List<User> users = kwetterService.findAllUsers();
        for(User u : users)
        {
            JSONPrep.prepToUserForJson(u);
        }
        //JSONPrep.prepToUserForJson(user);
        return users;
    }
    
    
//    @POST
//    @Path("/create")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    //install postman api for this
//    public Response createUser(String json) 
//    {
//        if(kwetterService.findByUserName(json) == null)
//        {
//            User user = new User(json);
//            kwetterService.createUser(user);
//            return Response.ok("Created " + json, MediaType.APPLICATION_JSON).build();
//        }
//        return Response.ok(json + " already exists.", MediaType.APPLICATION_JSON).build(); 
//    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@FormParam("username") String username) 
    {
        if(kwetterService.findByUserName(username) == null)
        {
            User user = new User(username);
            kwetterService.createUser(user);
            return Response.ok("Created " + username, MediaType.APPLICATION_JSON).build();
        }
        return Response.ok(username + " already exists.", MediaType.APPLICATION_JSON).build(); 
    }
    
//    @GET
//    @Path("/{username}")
//    public User getUser(@PathParam("username") String username){
//        return JSONPrep.prepToUserForJson(kwetterService.findByUserName(username));
//    }
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username)
    {
        
        if(JSONPrep.prepToUserForJson(kwetterService.findByUserName(username)) != null)
        {
            return JSONPrep.prepToUserForJson(kwetterService.findByUserName(username));
        }
        Response.ok(" already exists.", MediaType.APPLICATION_JSON).build(); 
        return null;
    }
    
    
    @GET
    @Path("/count")
    public int countUsers(){
        return kwetterService.countUsers();
    }
    
    @GET
    @Path("/remove/{username}")
    public String removeUser(@PathParam("username") String username)
    {
        User user = kwetterService.findByUserName(username);
        kwetterService.deleteUser(user);
        return "User has been removed.";
    }
    
    @GET
    @Path("/insert")
    public String insertUsers() {
        //addroles
        //Role regular = new Role("User");
        
        //saya
        User userSaya = new User("saya", "saya1234", "Saya Laugs", "Ik ben Ik", "Eindhoven", "www.saya.nl");
        Kweet kweetSaya = new Kweet("dit is een kweet", userSaya);
        userSaya.addKweet(kweetSaya);
        userSaya.setRole(new Role("moderator"));
        kwetterService.createUser(userSaya);
        
        //harry
        User userHarry = new User("harry", "harry1234", "Harry Harrison", "Ik ben Harry", "Eindhoven", "www.harry.nl");
        //Kweet kweetHarry = new Kweet("dit is een kweet", userHarry);
        //userHarry.addKweet(kweetHarry);
        userHarry.setPassword("df46219531cb5d522d0845901978dccfa286a5b0437f4f9cd4e485064f6b632c");
        userHarry.setRole(new Role("regular"));
        userHarry.addFollower(userSaya);
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
