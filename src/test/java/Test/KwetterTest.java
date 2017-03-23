/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Calendar;
import nl.fontys.jea.kwetter.Kweet;
import nl.fontys.jea.kwetter.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saya
 */
public class KwetterTest 
{
    
    User kweeter1;
    User kweeter2;
    User kweeter3;
    User kweeter4;
    User kweeter5;
    User kweeter6;
    User kweeter7;
    User kweeter8;
    User kweeter9;
    User kweeter10;

    Kweet kweet1;
    Kweet kweet2;
    Kweet kweet3;
    Kweet kweet4;
    Kweet kweet5;
    Kweet kweet6;
    Kweet kweet7;
    Kweet kweet8;
    Kweet kweet9;
    Kweet kweet10;

    @Before
    public void setUp() 
    {
        kweeter1 = new User("kweeter1");
        kweeter2 = new User("kweeter2");
        kweeter3 = new User("kweeter3");
        kweeter4 = new User("kweeter4");
        kweeter5 = new User("kweeter5");
        kweeter6 = new User("kweeter6");
        kweeter7 = new User("kweeter7");
        kweeter8 = new User("kweeter8");
        kweeter9 = new User("kweeter9");
        kweeter10 = new User("kweeter10");

        kweet1 = new Kweet("kweeter1's first tweet!", kweeter1, Calendar.getInstance());
        kweet2 = new Kweet("kweeter2's first tweet!", kweeter2, Calendar.getInstance());
        kweet3 = new Kweet("kweeter3's first tweet!", kweeter3, Calendar.getInstance());
        kweet4 = new Kweet("kweeter4's first tweet!", kweeter4, Calendar.getInstance());
        kweet5 = new Kweet("kweeter5's first tweet!", kweeter5, Calendar.getInstance());
        kweet6 = new Kweet("kweeter6's first tweet!", kweeter6, Calendar.getInstance());
        kweet7 = new Kweet("kweeter7's first tweet!", kweeter7, Calendar.getInstance());
        kweet8 = new Kweet("kweeter8's first tweet!", kweeter8, Calendar.getInstance());
        kweet9 = new Kweet("kweeter9's first tweet!", kweeter9, Calendar.getInstance());
        kweet10 = new Kweet("kweeter10's first tweet!", kweeter10, Calendar.getInstance());

        kweeter1.addFollower(kweeter2);
        kweeter2.addFollower(kweeter3);
        kweeter3.addFollower(kweeter4);
        kweeter4.addFollower(kweeter5);
        kweeter5.addFollower(kweeter6);
        kweeter6.addFollower(kweeter7);
        kweeter7.addFollower(kweeter8);
        kweeter8.addFollower(kweeter9);
        kweeter9.addFollower(kweeter10);
        kweeter10.addFollower(kweeter1);

        kweeter1.addFollowing(kweeter10);
        kweeter2.addFollowing(kweeter1);
        kweeter3.addFollowing(kweeter2);
        kweeter4.addFollowing(kweeter3);
        kweeter5.addFollowing(kweeter4);
        kweeter6.addFollowing(kweeter5);
        kweeter7.addFollowing(kweeter6);
        kweeter8.addFollowing(kweeter7);
        kweeter9.addFollowing(kweeter8);
        kweeter10.addFollowing(kweeter9);

        kweeter1.addKweet(kweet1);
        kweeter2.addKweet(kweet2);
        kweeter3.addKweet(kweet3);
        kweeter4.addKweet(kweet4);
        kweeter5.addKweet(kweet5);
        kweeter6.addKweet(kweet6);
        kweeter7.addKweet(kweet7);
        kweeter8.addKweet(kweet8);
        kweeter9.addKweet(kweet9);
        kweeter10.addKweet(kweet10);
    }

    @Test
    public void kweeterTest() 
    {
        assertEquals("kweeter1", kweeter1.getUsername());
        assertEquals("kweeter2", kweeter2.getUsername());
        assertEquals("kweeter3", kweeter3.getUsername());
        assertEquals("kweeter4", kweeter4.getUsername());
        assertEquals("kweeter5", kweeter5.getUsername());
        assertEquals("kweeter6", kweeter6.getUsername());
        assertEquals("kweeter7", kweeter7.getUsername());
        assertEquals("kweeter8", kweeter8.getUsername());
        assertEquals("kweeter9", kweeter9.getUsername());
        assertEquals("kweeter10", kweeter10.getUsername());
    }

    @Test
    public void KweetTest() 
    {
        assertEquals("kweeter1's first tweet!", kweet1.getMessage());
        assertEquals("kweeter2's first tweet!", kweet2.getMessage());
        assertEquals("kweeter3's first tweet!", kweet3.getMessage());
        assertEquals("kweeter4's first tweet!", kweet4.getMessage());
        assertEquals("kweeter5's first tweet!", kweet5.getMessage());
        assertEquals("kweeter6's first tweet!", kweet6.getMessage());
        assertEquals("kweeter7's first tweet!", kweet7.getMessage());
        assertEquals("kweeter8's first tweet!", kweet8.getMessage());
        assertEquals("kweeter9's first tweet!", kweet9.getMessage());
        assertEquals("kweeter10's first tweet!", kweet10.getMessage());
        assertEquals(kweet1, kweeter1.getKweets().get(0));
        assertEquals(kweet2, kweeter2.getKweets().get(0));
        assertEquals(kweet3, kweeter3.getKweets().get(0));
        assertEquals(kweet4, kweeter4.getKweets().get(0));
        assertEquals(kweet5, kweeter5.getKweets().get(0));
        assertEquals(kweet6, kweeter6.getKweets().get(0));
        assertEquals(kweet7, kweeter7.getKweets().get(0));
        assertEquals(kweet8, kweeter8.getKweets().get(0));
        assertEquals(kweet9, kweeter9.getKweets().get(0));
        assertEquals(kweet10, kweeter10.getKweets().get(0));
    }

    @Test
    public void FollowerTest() {
        assertEquals(kweeter2, kweeter1.getFollowers().get(0));
        assertEquals(kweeter3, kweeter2.getFollowers().get(0));
        assertEquals(kweeter4, kweeter3.getFollowers().get(0));
        assertEquals(kweeter5, kweeter4.getFollowers().get(0));
        assertEquals(kweeter6, kweeter5.getFollowers().get(0));
        assertEquals(kweeter7, kweeter6.getFollowers().get(0));
        assertEquals(kweeter8, kweeter7.getFollowers().get(0));
        assertEquals(kweeter9, kweeter8.getFollowers().get(0));
        assertEquals(kweeter10, kweeter9.getFollowers().get(0));
        assertEquals(kweeter1, kweeter10.getFollowers().get(0));
    }

    @Test
    public void FollowingTest() 
    {
        assertEquals(kweeter10, kweeter1.getFollowing().get(0));
        assertEquals(kweeter1, kweeter2.getFollowing().get(0));
        assertEquals(kweeter2, kweeter3.getFollowing().get(0));
        assertEquals(kweeter3, kweeter4.getFollowing().get(0));
        assertEquals(kweeter4, kweeter5.getFollowing().get(0));
        assertEquals(kweeter5, kweeter6.getFollowing().get(0));
        assertEquals(kweeter6, kweeter7.getFollowing().get(0));
        assertEquals(kweeter7, kweeter8.getFollowing().get(0));
        assertEquals(kweeter8, kweeter9.getFollowing().get(0));
        assertEquals(kweeter9, kweeter10.getFollowing().get(0));

   }
}

