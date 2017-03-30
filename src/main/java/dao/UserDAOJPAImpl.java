/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.User;

/**
 *
 * @author saya
 */
//@Stateless
//@LocalBean
//@EJB(beanInterface = UserDAOJPAImpl.class, name = "UserDAOJPAImpl")
public class UserDAOJPAImpl implements UserDao, Serializable 
{
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUKwetter");
    //@PersistenceContext(unitName = "PUKwetter")
    private EntityManager em = emf.createEntityManager();

    public UserDAOJPAImpl() {
    }
    
    
//    public UserDAOJPAImpl(EntityManager em)
//    {
//        this.em = em;
//    }
    
    public void setEm(EntityManager em) 
    {
        this.em = em;
    }

    @Override
    public int count() {
//        Query q = em.createNamedQuery("User.count", User.class);
//        return ((Long) q.getSingleResult()).intValue();

        Query query = em.createNamedQuery("User.count");
        try {
            return (int) query.getSingleResult();
        } catch (NoResultException ex) {
            return 0;
        }
    }

    @Override
    public void create(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        //em.close();
    }

    @Override
    public void edit(User user) {

        em.merge(user);
    }

    @Override
    public List<User> findAll() {
  
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
}
    }

    @Override
    public void remove(User user) {
        em.remove(user);
    }

    
    @Override
    public User findByUserName(String username) 
    {
        Query q = em.createNamedQuery("User.findByUserName", User.class);
        q.setParameter("username", username);
        try
        {
                return (User) q.getSingleResult();
        } 
        catch (Exception e)
        {
                return null;
        }
    }

    @Override
    public List<User> findAllUsersByName(String username) 
    {
        TypedQuery<User> q = em.createNamedQuery("User.findAllByUsername", User.class);
        q.setParameter("name", "%" + username + "%");
        try 
        {
            return q.getResultList();
        } 
        catch (NoResultException ex) 
        {
            return null;
        }
    }
}
