/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author saya
 */
public interface UserDao 
{
        /**
     *
     * @return number of user instances 
     */
    int count();

    /**
     * The user is persisted. If a user with the same email allready exists an EntityExistsException is thrown
     * @param user
     */
    void create(User user);

    /**
     * Merge the state of the given user into persistant context. If the user did not exist an IllegalArgumentException is thrown
     * @param user
     */
    void edit(User user);


    /**
     *
     * @return list of user instances
     */
    List<User> findAll();

    /**
     *
     * @param username
     * @return unique user instance with parameter email or null if such user doesn't exist
     */
    User findByUserName(String username);
    
    List<User> findAllUsersByName(String username);

    /**
     * Remove the entity instance
     * @param user - entity instance
     */
    void remove(User user);
    
    List<User> getAllFollowing(User user);

    List<User> getAllFollowers(User user);
    
    boolean login(String username, String password);
}
