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
        Portal portal1 = new Portal("Portal1",router);
        Portal portal2 = new Portal("Portal2",router);
        MetaAgent user1 = new UserAgent("User1",portal1);
        MetaAgent user2 = new UserAgent("User2",portal1);
        MetaAgent user3 = new UserAgent("User3",portal2);
        MetaAgent user4 = new UserAgent("User4",portal2);
        
        portal1.updateTable(user1.userName, user1);
        router.updateTable(user1.userName, portal1);
        portal1.updateTable(user2.userName, user2);
        router.updateTable(user2.userName, portal1);
//        portal1.updateTable(user3.userName, user3);
//        portal1.updateTable(user4.userName, user4);
        
        
        portal2.updateTable(user3.userName, user3);
        router.updateTable(user3.userName, portal2);
        portal2.updateTable(user4.userName, user4);
        router.updateTable(user4.userName, portal2);
//        portal2.updateTable(user1.userName, user1);
//        portal2.updateTable(user2.userName, user2);
        
        
        System.out.println(router.routing.containsKey(user1.userName));
        System.out.println(portal1.routingTable.containsKey(user1.userName));
        
        System.out.println(router.routing.containsKey(user2.userName));
        System.out.println(portal1.routingTable.containsKey(user2.userName));
        
        System.out.println(router.routing.containsKey(user3.userName));
        System.out.println(portal2.routingTable.containsKey(user3.userName));
        
        System.out.println(router.routing.containsKey(user4.userName));
        System.out.println(portal2.routingTable.containsKey(user4.userName));
        
        System.out.println(portal1.routingTable.containsKey("User2"));
        System.out.println(portal2.routingTable.containsKey("User2"));
        
        
        System.out.println("Portal1 HashMap: " + portal1.routingTable.toString());
        System.out.println("Portal2 HashMap: " + portal2.routingTable.toString());
        
        
        Message msg = new Message("User3", "Your nan is dead", "User1");
        user1.messageHandler(msg);
        
        
    }
    
}
