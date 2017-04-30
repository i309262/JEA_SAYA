/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Kweet;
import model.User;
import service.kwetterService;

/**
 *
 * @author Saya
 */
@Named(value = "UserBean")
@RequestScoped
public class UserBean implements Serializable{
    
    // @EJB
    @Inject
    private kwetterService kwetterService;

    private User user;
    private String username;
    private String password;
    private String name;
    private String bio;
    private String location;
    private String website;
    private List<User> followers = new ArrayList<User>();
    private List<User> following = new ArrayList<User>();
    private List<Kweet> kweets = new ArrayList<Kweet>();
    private String filter;

    public List<User> getUsers() {
        if (filter != null && filter.length() > 0) {
            List<User> filtered = new ArrayList<>();
            for (User s : kwetterService.findAllUsers()) {
                if (s.getUsername().toLowerCase().startsWith(filter)) {
                    filtered.add(s);
                }
            }
            return filtered;
        } else {
            return kwetterService.findAllUsers();
        }
    }
    
//    public User getUser(String username)
//    {
//        this.user = kwetterService.findByUserName(username);
//        return user;
//    }
//    
//    public List<Kweet> getKweetsByUserName(String usernm)
//    {
//        this.user = kwetterService.findByUserName(username);
//        this.kweets = user.getKweets();
//        return kweets;
//        //List<Kweet> foundKweets = user.getKweets();
//        //return foundKweets;
//    }
    
    public void loadUser(String username) 
    {
        User u = kwetterService.findByUserName(username);
        this.setUser(u);
    }
    
    public void addUser(){
        //User user = new User("egel", "216b24baf5c2190db6ef75c65bed1f5084fd97c936943b27da00601729955bec", "abc", "abc" , "abc" ,"abc");
        User user = new User(username, password, name, bio, location, website);
        kwetterService.createUser(user);
    }
    
    public void addFollower(String follower, User following){
        User founduser = kwetterService.findByUserName(follower);
        kwetterService.followUser(founduser, following);
    }

    public void removeUser(User user) {
        kwetterService.deleteUser(user);
    }
    
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) 
    {
        this.user = user;
    }
}
