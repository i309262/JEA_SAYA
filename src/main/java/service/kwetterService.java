/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.KweetDAOCollectionImpl;
import dao.KweetDAOJPAImpl;
import dao.UserDAOCollectionImpl;
import dao.UserDAOJPAImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
@Stateless
@Named
@LocalBean
public class kwetterService implements Serializable
{
//    @Inject
//    UserDAOCollectionImpl UserDAO;
    
    //@EJB(name = "UserDAOJPAImpl")
    @Inject
    UserDAOJPAImpl UserDAO;
    //UserDAOJPAImpl UserDAO = new UserDAOJPAImpl();
    //@EJB
    @Inject
    KweetDAOJPAImpl KweetDAO;
    //KweetDAOCollectionImpl KweetDAO = new KweetDAOCollectionImpl();
    
    //@Inject
    public kwetterService()
    {
        
    }
    
    public void createUser(User user) {
        UserDAO.create(user);
    }

    public void editUser(User user) {
        UserDAO.edit(user);
    }

    public void createKweet(Kweet kweet) {
        kweet.getPoster().addKweet(kweet);
        UserDAO.edit(kweet.getPoster());
        KweetDAO.create(kweet);
    }

    public void deleteUser(User user) {
        UserDAO.remove(user);
    }
    
    public void editKweet(Kweet kweet) {
        KweetDAO.edit(kweet);
    }

    public List<User> findAllUsers() {
        return UserDAO.findAll();
    }

    public void deleteKweet(Kweet kweet) {
        KweetDAO.remove(kweet);
    }
    
    public int countUsers()
    {
        return UserDAO.count();
    }

    public List<Kweet> findAllKweets() {
        return KweetDAO.findAll();
    }

    public User findByUserName(String name) {
        return UserDAO.findByUserName(name);
    }

    public List<Kweet> findKweetsByUsername(String username) {
        return KweetDAO.findKweetsByUsername(username);
    }

    public List<User> findAllUsersByName(String name) {
        return UserDAO.findAllUsersByName(name);
    }
    
    public void followUser(User follower, User following) {
        follower.addFollowing(following);
        UserDAO.edit(follower);
        UserDAO.edit(following);
    }
    

    public List<User> getFollowing(User user) {
        return UserDAO.getAllFollowing(user);
    }

    public List<User> getFollowers(User user) {
        return UserDAO.getAllFollowers(user);
    }
    
    public List<Kweet> getAllKweets(String username) 
    {
        List<Kweet> kweets = new ArrayList<>();
        //all kweets from following, might also be possible with just user.getfollowing
        for (User u : UserDAO.findByUserName(username).getFollowing()) {
            kweets.addAll(u.getKweets());
        }
        //all kweets from logged in user
        kweets.addAll(UserDAO.findByUserName(username).getKweets());
        Collections.sort(kweets);
        Collections.reverse(kweets);
        return kweets;
    }
    
    public List<Kweet> getKweetByText(String message) 
    {
        List<Kweet> foundKweets = KweetDAO.findByText(message);
        Collections.sort(foundKweets);
        Collections.reverse(foundKweets);
        return foundKweets;
    }
    
    public List<Kweet> getTop10Kweets(String username) 
    {
        List<Kweet> kweets = new ArrayList<>();      
        
        kweets.addAll(UserDAO.findByUserName(username).getKweets());
        Collections.sort(kweets);
        Collections.reverse(kweets);
        if(kweets.size() < 10)
        {
            return kweets;
        }
        else
        {
            return kweets.subList(0, 10);
        }
    }
    
    public boolean login(String userName, String password) 
    {
        return UserDAO.login(userName, password);
    }
        
    public void editBio(String username, String bio) {
        User user = this.findByUserName(username);
        user.setBio(bio);
        this.editUser(user);
    }

//    public void removeFollowing(User leader, User following) {
//        leader.removeFollowing(following);
//        UserDAO.editUser(leader);
//        UserDAO.editUser(following);
//    }

//    public void removeFollower(User leader, User follower) {
//        leader.removeFollower(follower);
//        UserDAO.editUser(leader);
//        UserDAO.editUser(follower);
//    }
}
