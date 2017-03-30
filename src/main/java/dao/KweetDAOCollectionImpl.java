/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
public class KweetDAOCollectionImpl implements KweetDao  
{
    
    private List<Kweet> kweets;

    public KweetDAOCollectionImpl() {
        kweets = new ArrayList<>();
    }

    @Override
    public int count() {
        return kweets.size();
    }

    @Override
    public void create(Kweet kweet) {
//         if (findByUserName(user.getUsername()) != null) {
//            throw new EntityExistsException();
//        }
        kweets.add(kweet);
    }
    
    @Override
    public void edit(Kweet kweet) {
        throw new UnsupportedOperationException("Edit not supported");
    }

    @Override
    public List<Kweet> findAll() {
        return kweets;
    }


    @Override
    public void remove(Kweet kweet) {
        kweets.remove(kweet);
    }

    @Override
    public List<Kweet> findByUser(User user) {
        List<Kweet> foundkweets = new ArrayList<>();
        for(Kweet k : kweets)
        {
            if(k.getPoster().equals(user))
            {
             foundkweets.add(k);   
            }
        }
        
        return foundkweets;
    }
}
