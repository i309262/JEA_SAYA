/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Calendar;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import model.Kweet;
import model.User;
import service.kwetterService;

/**
 * Created by Brian
 */

@MessageDriven(mappedName = "jms/myQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                                    propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                    propertyValue = "javax.jms.Queue")
})
public class MessageBean implements MessageListener {
    
    @EJB
    kwetterService kwetterService;
    
    public MessageBean() {
    }

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                User user = kwetterService.findByUserName("KwetterJMS");
                Kweet kweet = new Kweet(msg.getText(), user);
                kwetterService.createKweet(kweet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}