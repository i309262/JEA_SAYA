/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.UserDAOCollectionImpl;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author saya
 */
public class UserDOACollectionTest 
{
    
    private UserDAOCollectionImpl userDAO = new UserDAOCollectionImpl();
    
    public UserDOACollectionTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void createUserTest() 
    {
        User user = new User("Saya");
        userDAO.create(user);
        //Assert.assertEquals("leuk", 1, userDAO.findByUserName(username))
        Assert.assertEquals("Expected 1 , its not 0", 1, userDAO.findAll().size());
    }
    
    @Test
    public void removeUserTest() 
    {
        User user = new User("Saya");

        userDAO.create(user);
        userDAO.remove(user);

        Assert.assertEquals("expected 0, its not 0", 0, userDAO.findAll().size());
    }
    
    @Test
    public void findUserTest()
    {
        User user = new User("Saya");
        userDAO.create(user);
        
        User user2 = userDAO.findByUserName(user.getUsername());
        Assert.assertEquals("expected Saya, its not Saya", "Saya", user2.getUsername());
    }
}
