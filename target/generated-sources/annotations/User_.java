import javax.annotation.Generated;
import javax.management.relation.Role;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-22T20:15:55")
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
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> username;

}