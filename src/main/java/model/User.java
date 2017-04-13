package model;


import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
  @NamedQueries
        (
         {
    @NamedQuery(name = "User.findAll", query = "FROM User u"),
    @NamedQuery(name = "User.count", query = "select count(u) from User as u"),
    @NamedQuery(name = "User.findByUserName", query = "select u from User as u where u.username = :username")
         }
        )
  @Table(name = "user")
  public class User implements Serializable
  {
    //@Id @GeneratedValue
    //private long id;
    //@Column(unique = true)
    @Id
    private String username;
    private String password;
    private String name;
    private String bio;
    private String location;
    private String website;
    
    @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL)
    private List<Kweet> kweets = new ArrayList<Kweet>();
    
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "USER_FOLLOWERS",
            joinColumns = @JoinColumn(
                    name = "user",
                    referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(
                    name = "followers",
                    referencedColumnName = "username"
            )
    )
    private List<User> followers = new ArrayList<User>();
    
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "USER_FOLLOWING",
            joinColumns = @JoinColumn(
                    name = "user",
                    referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(
                    name = "following",
                    referencedColumnName = "username"
            )
    )
    private List<User> following = new ArrayList<User>();
    private Role role;
	
    public User()
    {
    	
    }
    
    public User(String username)
    {
    	this.username = username;
    }
    
    public User(String username, String password)
    {
    	this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String name, String bio, String location, String website) 
    {   
        this.username = username;
        this.password = sha256(password);
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.website = website;
    }

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
        kweets.add(kweet);
    }

    public void addFollower(User user)
    {
        if (user != null && user != this && !followers.contains(user))
        {
                followers.add(user);
        }
    }

    public void addFollowing(User follow) {
        if (follow != null && following != null) {
            following.add(follow);
            follow.addFollower(this);
        }
    }
	
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
}

