package nl.fontys.jea.kwetter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saya
 */
  @Entity
  public class User implements Serializable
  {
    @Id @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String name;
    private String bio;
    private String location;
    private String website;
    private List<Kweet> kweets = new ArrayList<Kweet>();
    private List<User> followers = new ArrayList<User>();
    private List<User> following = new ArrayList<User>();
    private Role role;
	
    public User()
    {
    	
    }
    
    public User(String username)
    {
    	this.username = username;
    }
    
//    public User(String username, String password, String name, String bio, String location, String website) 
//    {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.bio = bio;
//        this.location = location;
//        this.website = website;
//    }

    public String getUsername() 
    {
        return username;
    }
    
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getBio() 
    {
        return bio;
    }

    public void setBio(String bio) 
    {
        this.bio = bio;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getWebsite() 
    {
        return website;
    }

    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public List<Kweet> getKweets() 
    {
        return kweets;
    }

    public void setKweets(List<Kweet> kweets) 
    {
        this.kweets = kweets;
    }

    public List<User> getFollowers() 
    {
        return followers;
    }

    public void setFollowers(List<User> followers) 
    {
        this.followers = followers;
    }

    public List<User> getFollowing() 
    {
        return following;
    }

    public void setFollowing(List<User> following) 
    {
        this.following = following;
    }

    public Role getRole() 
    {
        return role;
    }

    public void setRole(Role role) 
    {
        this.role = role;
    }

    public void addKweet(Kweet kweet) 
    {
    if(kweet != null)
    {
        kweets.add(kweet);
    }
}

    public void addFollower(User kwetteraar)
    {
        if (kwetteraar != null && kwetteraar != this && !followers.contains(kwetteraar))
        {
                followers.add(kwetteraar);
        }
    }

    public void addFollowing(User kwetteraar)
    {
        if (kwetteraar != null && kwetteraar != this && !followers.contains(kwetteraar))
        {
                following.add(kwetteraar);
        }
    }
	
}

