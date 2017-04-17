/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
@RequestScoped
public class KweetDAOJPAImpl implements KweetDao
{

    //public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUKwetter");
    @PersistenceContext(unitName = "PUKwetter")
    private EntityManager em;
    //private EntityManager em = emf.createEntityManager();
    
    @Override
    public int count() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Kweet kweet) 
    {
        em.persist(kweet);
    }

    @Override
    public void edit(Kweet kweet) 
    {
        em.merge(kweet);
    }

    @Override
    public List<Kweet> findAll() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kweet> findByUser(User user) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Kweet kweet) 
    {
    }

    @Override
    public List<Kweet> findKweetsByUsername(String username) 
    {
        Query q = em.createNamedQuery("Kweet.findAllByUser", Kweet.class);
        q.setParameter("poster", username);
        try
        {
                return q.getResultList();
        } 
        catch (Exception e)
        {
                return null;
        }
    }
    
}
