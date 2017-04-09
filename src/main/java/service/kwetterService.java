/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.KweetDAOCollectionImpl;
import dao.UserDAOCollectionImpl;
import dao.UserDAOJPAImpl;
import java.io.Serializable;
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
    KweetDAOCollectionImpl KweetDAO = new KweetDAOCollectionImpl();
    
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

    public List<Kweet> findAllKweetsByUser(User user) {
        return KweetDAO.findByUser(user);
    }

    public List<User> findAllUsersByName(String name) {
        return UserDAO.findAllUsersByName(name);
    }
}
