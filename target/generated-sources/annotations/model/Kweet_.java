package model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-10T21:32:35")
@StaticMetamodel(Kweet.class)
public class Kweet_ { 

    public static volatile SingularAttribute<Kweet, Calendar> datetime;
    public static volatile SingularAttribute<Kweet, Integer> id;
    public static volatile SingularAttribute<Kweet, String> message;
    public static volatile SingularAttribute<Kweet, User> poster;

}