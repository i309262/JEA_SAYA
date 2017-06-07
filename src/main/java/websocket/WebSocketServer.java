/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import model.User;
import service.kwetterService;

/**
 *
 * @author saya
 */
//@ApplicationScoped
@ServerEndpoint("/socket")
public class WebSocketServer 
{
//   @Inject
//    private SessionHandler sessionHandler;
    
    @OnOpen
    public void open(Session session) 
    {
        SessionHandler.getInstance().getSessions().add(session);
    }

    @OnClose
    public void close(Session session) 
    {
    }

    @OnError
    public void onError(Throwable error) 
    {
    }

    @OnMessage
    public void handleMessage(String message, Session session) 
    {
        SessionHandler.getInstance().sendToAllConnectedSessions(message);
    }
}
