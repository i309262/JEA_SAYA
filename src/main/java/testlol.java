
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saya
 */
public class testlol implements Serializable
{
    @Id @GeneratedValue
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public testlol(long id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
//    public testlol()
//    {
//        
//    }
}
