///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Test;
//
//import dao.KweetDAOCollectionImpl;
//import java.util.Calendar;
//import model.Kweet;
//import model.User;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// *
// * @author saya
// */
//public class KweetDAOCollectionTest 
//{
//       private KweetDAOCollectionImpl kweetDAO = new KweetDAOCollectionImpl();
//
//    @Before
//    public void Setup() { 
//    }
//
//    @Test
//    public void createKweetTest() {
//        User user = new User("Saya");
//
//        Kweet kweet = new Kweet("dit is een test kweet", user);
//
//        kweetDAO.create(kweet);
//        Assert.assertEquals("Expected 1 kweet, not 1 kweet", 1, kweetDAO.findAll().size());
//    }
//
//    @Test
//    public void deleteKweetTest() {
//
//        User user = new User("Saya");
//        
//        Kweet kweet = new Kweet("dit is een test kweet", user);
//
//        kweetDAO.create(kweet);
//        kweetDAO.remove(kweet);
//
//        Assert.assertEquals("Expected 0 kweets, got more", 0, kweetDAO.findAll().size());
//}
//}
