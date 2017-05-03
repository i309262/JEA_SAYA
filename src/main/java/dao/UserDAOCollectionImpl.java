/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
public class UserDAOCollectionImpl implements UserDao
{

    //private HashMap<String, User> users;
    private List<User> users;

    public UserDAOCollectionImpl() {
        //users = new HashMap<String, User>();
        users = new ArrayList<>();
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public void create(User user) {
        //users.put(user.getUsername(), user);
        users.add(user);
    }

    @Override
    public void edit(User user) {
        throw new UnsupportedOperationException("Edit not supported");
    }


    @Override
    public List<User> findAll() {
        //return new ArrayList<User>(users.values());
        return users;
    }


    @Override
    public void remove(User user) {
        //users.remove(user.getUsername());
        users.remove(user);
    }

    @Override
    public User findByUserName(String username) {
         //return users.get(username);
         for(User u : users)
         {
             if(u.getUsername().equals(username))
             {
                 return u;
             }
         }
         return null;
    }

    @Override
    public List<User> findAllUsersByName(String username) {
        List<User> foundusers = new ArrayList<>();
        for(User u : users)
        {
            if(u.getUsername().equals(username))
            {
                foundusers.add(u);
            }
        }
        
        return foundusers;
    }

    @Override
    public List<User> getAllFollowing(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllFollowers(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
