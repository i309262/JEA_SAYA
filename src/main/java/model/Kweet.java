package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saya
 */
@Entity
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kweet.findAll", query = "SELECT k FROM Kweet k"),
    @NamedQuery(name = "Kweet.findByID", query = "SELECT k FROM Kweet k WHERE k.id = :id"),
    @NamedQuery(name = "Kweet.findAllByUser", query = "SELECT k FROM Kweet k WHERE k.poster = :poster")
    })
    public class Kweet implements Serializable , Comparable<Kweet>
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    
    //@ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poster")
    //@ManyToOne(optional = false)
    private User poster;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datetime;

    public Kweet(String message, User poster) {
        this.message = message;
        this.poster = poster;
        this.datetime = Calendar.getInstance();
    }

//    public Kweet(/*long id, */String message)
//    {
//        //this.id = id;
//        this.message = message;
//    }
    
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public void createKweet(String message, User kwetteraar) {
        Kweet kweet = new Kweet();
        kweet.setPoster(kwetteraar);
        kweet.setMessage(message);
        kweet.setDatetime(Calendar.getInstance());
    }
    
    
    @Override
    public int compareTo(Kweet o) {
        return getDatetime().compareTo(o.getDatetime());
    }

    public Kweet() {

    }
}
