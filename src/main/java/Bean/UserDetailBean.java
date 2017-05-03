/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Kweet;
import model.User;
import rest.JSONPrep;
import service.kwetterService;

/**
 *
 * @author Saya
 */
@Named(value = "UserDetailBean")
@RequestScoped
public class UserDetailBean implements Serializable{

    //@EJB
    @Inject
    private kwetterService kwetterService;
    private String message;
    private User user;
    private String kweetFilter;
    private String userFilter;
    private String bio;
    private String location;
    private String website;

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    public UserDetailBean() {
    }

    public List<Kweet> searchKweets() {
        if (kweetFilter != null && kweetFilter.length() > 0) {
            List<Kweet> filtered = new ArrayList<>();
            for (Kweet k : kwetterService.getAllKweets(user)) {
                if (k.getMessage().toLowerCase().startsWith(kweetFilter)) {
                    filtered.add(k);
                }
            }
            return filtered;
        } else {
            return kwetterService.getAllKweets(user);
        }
    }
    
    public List<User> searchUsers() 
    {
        if (userFilter != null && userFilter.length() > 0) 
        {
            List<User> filtered = new ArrayList<>();
            for (User u : kwetterService.findAllUsers()) 
            {
                if (u.getUsername().toLowerCase().startsWith(userFilter)) 
                {
                    filtered.add(u);
                }
            }
            return filtered;
        } 
        else 
        {
            return null;
        }
    }
    
    public void loadUser(String username) 
    {
        User u = kwetterService.findByUserName(username);
        this.setUser(u);
    }
    
    public void addFollower(String follower)
    {

        Map<String,String> params = externalContext.getRequestParameterMap();
        String following = params.get("following");
        
        User foundfollower = kwetterService.findByUserName(follower);
        User foundfollowing = kwetterService.findByUserName(following);
        kwetterService.followUser(foundfollower, foundfollowing);
    }

    public void addKweet(String username)
    {
        User u = kwetterService.findByUserName(username);
        Kweet k = new Kweet(message, u);
        kwetterService.createKweet(k);
        //user.addKweet(k);
    }
    
    public List<Kweet> allKweets()
    {
        return kwetterService.getAllKweets(user);
    }
    
    public List<User> allFollowing()
    {
        return kwetterService.getFollowing(user);
    }
    
    public List<User> allFollowers()
    {
        return kwetterService.getFollowers(user);
    }
    
    public List<Kweet> top10Kweets(String username)
    {
        //User u = kwetterService.findByUserName(username);
        return kwetterService.getTop10Kweets(user);
    }
    
    public String selectUsers() 
    {
        return "user?faces-redirect=true";
    }
    
    public String showProfile(String username) 
    {
        return "/user.xhtml";
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) 
    {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKweetFilter() {
        return kweetFilter;
    }

    public void setKweetFilter(String filter) {
        this.kweetFilter = filter;
    }

    public String getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    
}
