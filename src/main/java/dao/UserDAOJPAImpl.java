/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import nl.fontys.jea.kwetter.User;

/**
 *
 * @author saya
 */
public class UserDAOJPAImpl implements UserDao 
{
 // private HashMap<String, User> users;
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUauction");
    public EntityManager em;


    public UserDAOJPAImpl(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public int count() {
        //return users.size();
        Query q = em.createNamedQuery("User.count", User.class);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public void create(User user) {
         if (findByEmail(user.getEmail()) != null) {
            throw new EntityExistsException();
        }
        em.persist(user);
        //users.put(user.getEmail(), user);
    }

    @Override
    public void edit(User user) {
        if (findByEmail(user.getEmail()) == null) {
            throw new IllegalArgumentException();
        }
        //users.put(user.getEmail(), user);
        em.merge(user);
    }

       @Override
    public List<User> findAll() {
        //return new ArrayList<User>(users.values());

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(User.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public User findByEmail(String email) {
        //return em.find(User.class, email);

        Query q = em.createNamedQuery("User.findByEmail", User.class);
        q.setParameter("email", email);
        try
        {
            return (User) q.getSingleResult();
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public void remove(User user) {
        em.remove(user);
        //users.remove(user.getEmail());
    }

    
}
