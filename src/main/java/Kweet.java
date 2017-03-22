
import commons.domain.BaseEntity;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Entity @XmlRootElement
public class Kweet implements Serializable 
{
    @Id @GeneratedValue
    private long id;
    private String message;
    private User poster;
    private Calendar datetime;

    public Kweet(String message, User poster, Calendar datetime) 
    {
        this.message = message;
        this.poster = poster;
        this.datetime = datetime;
    }

    public Kweet(long id, String message)
    {
        this.id = id;
        this.message = message;
    }
    

    public String getMessage() 
    {
        return message;
    }

    public void setMessage(String message) 
    {
        this.message = message;
    }

    public User getPoster() 
    {
        return poster;
    }

    public void setPoster(User poster) 
    {
        this.poster = poster;
    }

    public Calendar getDatetime() 
    {
        return datetime;
    }

    public void setDatetime(Calendar datetime) 
    {
        this.datetime = datetime;
    }

    public void createKweet(String message, User kwetteraar)
    {
        Kweet kweet = new Kweet();
        kweet.setPoster(kwetteraar);
        kweet.setMessage(message);
        kweet.setDatetime(Calendar.getInstance());
    }
    
//    public Kweet()
//    {
//
//    }
}
