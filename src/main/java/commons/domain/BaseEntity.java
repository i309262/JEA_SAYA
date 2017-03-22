/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author saya
 */
public class BaseEntity 
{
    @Id @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
