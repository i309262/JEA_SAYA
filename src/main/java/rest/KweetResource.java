/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import model.Kweet;
import model.User;
import service.kwetterService;

/**
 *
 * @author saya
 */
@Path("/kweet")
public class KweetResource
{
    
    @EJB
    kwetterService kwetterService;

    @GET
    @Path("/all")
    public List<Kweet> listAllKweets() {
        return kwetterService.findAllKweets();
    }

    @GET
    @Path("/{username}")
    public List<Kweet> listPosterForKweet(@PathParam("username") String username) {
        //User user = kwetterService.findByUserName(username);
        return kwetterService.findKweetsByUsername(username);
    }
}
