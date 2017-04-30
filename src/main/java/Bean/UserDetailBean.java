/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
public class UserDetailBean {

    //@EJB
    @Inject
    private kwetterService kwetterService;
    private String message;
    private User user;
    private String filter;
    private String bio;
    private String location;
    private String website;

    public UserDetailBean() {
    }

    public List<Kweet> searchKweets() {
        if (filter != null && filter.length() > 0) {
            List<Kweet> filtered = new ArrayList<>();
            for (Kweet k : kwetterService.getAllKweets(user)) {
                if (k.getMessage().toLowerCase().startsWith(filter)) {
                    filtered.add(k);
                }
            }
            return filtered;
        } else {
            return kwetterService.getAllKweets(user);
        }
    }
    
    public void loadUser(String username) 
    {
        User u = kwetterService.findByUserName(username);
        this.setUser(u);
    }

    public void addKweet(String username)
    {
        User u = kwetterService.findByUserName(username);
        Kweet k = new Kweet(message, u);
        kwetterService.createKweet(k);
        //user.addKweet(k);
    }
    
    public List<Kweet> allKweets()//String username)
    {
        ///User u = kwetterService.findByUserName(username);
        return kwetterService.getAllKweets(user);
    }
    
    public List<Kweet> top10Kweets(String username)
    {
        User u = kwetterService.findByUserName(username);
        return kwetterService.getTop10Kweets(user);
    }
    
    public String selectUsers() 
    {
        return "user?faces-redirect=true";
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

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
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
