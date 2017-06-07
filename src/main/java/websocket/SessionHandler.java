/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.Session;
import model.User;

/**
 *
 * @author saya
 */
//@ApplicationScoped
public class SessionHandler 
{
    private final Set<Session> sessions = new HashSet<>();
    private static SessionHandler sessionHandler = null;
    
    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
//        sessions.remove(session);
    }

    
    public static SessionHandler getInstance() {
        if (sessionHandler == null) {
            sessionHandler = new SessionHandler();
        }
        return sessionHandler;
    }

    public void sendToAllConnectedSessions(String message) 
    {
        for (Session session : sessions) 
        {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, String message) 
    {
        session.getAsyncRemote().sendText(message);
    }
    
    public Set<Session> getSessions()
    {
        return this.sessions;
    }
            
}
