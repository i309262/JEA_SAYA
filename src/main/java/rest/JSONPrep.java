/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import model.Kweet;
import model.User;

/**
 *
 * @author saya
 */
public class JSONPrep 
{
    
    private JSONPrep()
    {
        //Empty constructor private constructor to make it impossible to instantiate this static class
    }

    public static User prepToUserForJson(User user){
        user.setPassword(null);
        //user.setKweets(null);
         
        if (user.getKweets() != null){
            for(Kweet k : user.getKweets())
            {
                prepKweetInUser(k);
            }
            //user.getKweets().forEach(JsonPrep::prepKweetInUser);
        }

//        if (user.getFollowing() != null){
//            user.getFollowing().forEach(JSONPrep::prepUserInKweetForJson);
//        }
//        if (user.getFollowers() != null){
//            user.getFollowers().forEach(JSONPrep::prepUserInKweetForJson);
//        }
        return user;
    }

    public static User prepUserInKweetForJson(User user){
        user.setPassword(null);
        user.setKweets(null);
        user.setFollowers(null);
        user.setFollowing(null);
        return user;
    }

    public static Kweet prepToKweetforJson(Kweet kweet){
        if (kweet.getPoster() != null) {
            JSONPrep.prepUserInKweetForJson(kweet.getPoster());
        }

        return kweet;
    }

    public static Kweet prepKweetInUser(Kweet kweet){
        if (kweet.getPoster() != null){
            kweet.setPoster(new User(kweet.getPoster().getUsername()));
        }

        return kweet;
    }
    
}
