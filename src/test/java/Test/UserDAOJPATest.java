///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Test;
//
//import model.User;
//import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//import org.junit.*;
//import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertNull;
//import service.UserManager;
//
///**
// *
// * @author saya
// */
//public class UserDAOJPATest {
//    
//    private UserManager userManager;
//    
//    public UserDAOJPATest() {
//    }
//    
//    @Before
//    public void setUp() {
//        userManager = new UserManager();
//    }
//
//    @Test
//    public void registerUser() {
//        User user1 = userManager.registerUser("SayaLaugs");
//        assertTrue(user1.getUsername().equals("SayaLaugs"));
//        User user2 = userManager.registerUser("RobertHorvers");
//        assertTrue(user2.getUsername().equals("RobertHorvers"));
////        User user2bis = userManager.registerUser("RobertHorvers");
////        assertNotSame(user2bis, user2);
//    }
//}
