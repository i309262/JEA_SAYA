/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.User;
import service.kwetterService;

/**
 *
 * @author Saya
 */
@Named(value = "UserDetailBean")
@RequestScoped
public class UserDetailBean {

    //@EJB
    @Inject
    private kwetterService kwetterService;
    private String username;
    private User user;

    public UserDetailBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadStudent() {
        User u = kwetterService.findByUserName(username);
        this.setUser(u);
    }

    public String selectUsers() {
        return "student?faces-redirect=true";
    }
}
