package model.two;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Kweet;
import model.Role;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-07T20:28:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> website;
    public static volatile ListAttribute<User, User> followers;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile ListAttribute<User, User> following;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> bio;
    public static volatile ListAttribute<User, Kweet> kweets;
    public static volatile SingularAttribute<User, String> location;
    public static volatile SingularAttribute<User, String> username;

}