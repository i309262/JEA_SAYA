/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author saya
 */
@Entity
public class Role implements Serializable
{
    @Id
    private String groupname;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "rolename",
                    referencedColumnName = "groupname"),
            inverseJoinColumns = @JoinColumn(name = "username",
                    referencedColumnName = "username"))
    private List<User> users;
    
    public Role(String groupName) {
        this.groupname = groupName;
    }

    public Role() {
    }

    public String getGroupName() {
        return groupname;
    }

    public void setGroupName(String groupName) {
        this.groupname = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
