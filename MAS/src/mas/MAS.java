/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author t7091808
 */
public class MAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        
        Router router = new Router("Router1");
        Portal portal = new Portal("Portal1",router);
        MetaAgent user1 = new UserAgent("User1",portal);
        MetaAgent user2 = new UserAgent("User2",portal);
        
        portal.updateTable("User1", user1);
        router.updateTable("User1", portal);
        portal.updateTable("User2", user2);
        router.updateTable("User2", portal);
        
        System.out.println(router.routing.containsKey("User1"));
        System.out.println(portal.routingTable.containsKey("User1"));
        
        Message msg = new Message("User1", "Your nan is dead", "User2");
        user2.messageHandler(msg);
        user1.messageHandler(new Message("User2", "My nan is dead now", "User1"));
        
    }
    
}
