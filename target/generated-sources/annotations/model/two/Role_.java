package model.two;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Role;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T12:03:32")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> groupname;
    public static volatile ListAttribute<Role, User> users;

}