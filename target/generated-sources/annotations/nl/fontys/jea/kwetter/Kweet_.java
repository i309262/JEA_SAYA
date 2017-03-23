package nl.fontys.jea.kwetter;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nl.fontys.jea.kwetter.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-23T11:03:27")
@StaticMetamodel(Kweet.class)
public class Kweet_ { 

    public static volatile SingularAttribute<Kweet, Calendar> datetime;
    public static volatile SingularAttribute<Kweet, Long> id;
    public static volatile SingularAttribute<Kweet, String> message;
    public static volatile SingularAttribute<Kweet, User> poster;

}