/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.UserDAOJPAImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Role;
import model.User;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
//import service.UserManager;

/**
 *
 * @author saya
 */
public class UserDAOJPATest {
    
    private UserDAOJPAImpl userDAO = new UserDAOJPAImpl();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUKwetterTest");
    private EntityManager em;
    Role role = new Role("User");
    private List<Role> roles;
    User user;
    
    public UserDAOJPATest() 
    {
        em = emf.createEntityManager();
    }
    
    @Before
    public void setUp() throws SQLException 
    {
        //DatabaseCleaner db = new DatabaseCleaner(em);
        //db.clean();

        roles = new ArrayList<>();
        roles.add(role);
        em = emf.createEntityManager();
        userDAO.setEm(em);
        user = new User("vis", "aapw8woord", "vis", "Ik ben vis", "Roermond", "www.google.com");
        //kwetteraar.setRoles(roles);
    }
    
    @Test
    public void createAndRemoveKwetteraarTest() 
    {
        em.getTransaction().begin();
        userDAO.create(user);
        userDAO.remove(user);
        em.getTransaction().commit();
    }
    
    @Test
    public void editKwetteraarTest() 
    {
        em.getTransaction().begin();
        userDAO.create(user);
        user.setName("aaperino");
        userDAO.edit(user);
        userDAO.remove(user);
        em.getTransaction().commit();
    }
}
