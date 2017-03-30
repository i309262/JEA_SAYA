/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
public interface KweetDao 
{
        /**
     *
     * @return number of user instances 
     */
    int count();

    /**
     * The user is persisted. If a user with the same email allready exists an EntityExistsException is thrown
     * @param kweet
     */
    void create(Kweet kweet);

    void edit(Kweet kweet);

    /**
     *
     * @return list of user instances
     */
    List<Kweet> findAll();

    /**
     *
     * @param kweet
     * @return unique user instance with parameter email or null if such user doesn't exist
     */
    List<Kweet> findByUser(User user);

    /**
     * Remove the entity instance
     * @param kweet
     */
    void remove(Kweet kweet);
}
