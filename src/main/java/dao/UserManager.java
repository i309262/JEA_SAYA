///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import dao.*;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import model.User;
//
///**
// *
// * @author saya
// */
//public class UserManager 
//{
//    //bij iedere test een nieuwe Entity manager aanmaken
//    
//    private UserDao userDAO;
//    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUkwetter");
//    public EntityManager em;
//
//    public UserManager() {
//        em = emf.createEntityManager();
//        //userDAO = new UserDAOJPAImpl(em);
//        //userDAO.setEm(em);
//    }
//
//    /**
//     * Registreert een gebruiker met het als parameter gegeven username, mits
//     * zo'n gebruiker nog niet bestaat.
//     * @param username
//     * @return Een Userobject dat geïdentificeerd wordt door het gegeven
//     * username
//     */
//    public User registerUser(String username) {
//        
////        User user = userDAO.findByUserName(username);
////        if (user != null) {
////            return user;
////        }
//        User user = new User(username);
//
//        //em.getTransaction().begin();
//        //em.persist(user);
//        userDAO.create(user);
//        //em.getTransaction().commit();
//
//        
//        return user;
//    }
//    
//    public void editUser(String username)
//    {
//        User user = userDAO.findByUserName(username);
//        if(user != null)
//        {
//            em.getTransaction().begin();
//            userDAO.edit(user);
//            em.getTransaction().commit();
//        }
//    }
//    
//    public void removeUser(String username)
//    {
//        User user = userDAO.findByUserName(username);
//        if(user != null)
//        {
//            em.getTransaction().begin();
//            userDAO.remove(user);
//            em.getTransaction().commit();
//        }
//    }
//
//    /**
//     *
//     * @param username een e-mailadres
//     * @return Het Userobject dat geïdentificeerd wordt door het gegeven
//     * e-mailadres of null als zo'n User niet bestaat.
//     */
//    public User getUser(String username) {
//        return userDAO.findByUserName(username);
//    }
//
//    /**
//     * @return Een iterator over alle geregistreerde gebruikers
//     */
//    public List<User> getUsers() {
//        return userDAO.findAll();
//    }
//}
