package rest;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.Kweet;
import model.User;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
@PermitAll
public class UserResource
{
    @Inject
    kwetterService kwetterService;
    
    
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
    @Path("followers/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getFollowers(@PathParam("username") String username) 
    {
        return JSONPrep.prepToUserForJson(kwetterService.findByUserName(username)).getFollowers();
    }
    
    @GET
    @Path("following/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getFollowing(@PathParam("username") String username) 
    {
        return JSONPrep.prepToUserForJson(kwetterService.findByUserName(username)).getFollowing();
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
    public String insertUsers() throws UnsupportedEncodingException, NoSuchAlgorithmException {
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
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public User inloggen(@FormParam("username") String username, @FormParam("password") String password) {

        String hashstring = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            hashstring = hexString.toString();
        } catch (Exception x) {
            System.out.println(x);
        }
        String hashedPassword = (hashstring == null || hashstring.isEmpty()) ? password : hashstring;
        if (kwetterService.login(username, hashedPassword)) 
        {
            User user = kwetterService.findByUserName(username);

            return JSONPrep.prepToUserForJson(user);
        }
        return new User(hashedPassword);
    }
    
    @POST
    @Path("edituser")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean editUser(@FormParam("username") String username, @FormParam("name") String name, @FormParam("locatie") String locatie, @FormParam("website") String website ,@FormParam("bio") String bio) {

        User user = kwetterService.findByUserName(username);
        user.setName(name);
        user.setLocation(locatie);
        user.setWebsite(website);
        user.setBio(bio);
        if (user != null) {
            kwetterService.editUser(user);
            return true;
        }
        return false;
    }
    
    @POST
    @Path("follow")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean followUser(@FormParam("follower") String followerName, @FormParam("leader") String leaderName) {

        User follower = kwetterService.findByUserName(followerName);
        User leader   = kwetterService.findByUserName(leaderName);
        kwetterService.followUser(follower, leader);
        
        return true;
    }
}
