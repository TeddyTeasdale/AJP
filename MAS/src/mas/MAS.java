/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

/**
 *
 * @author t7091808
 */
public class MAS
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        
//        //Router router = new Router("Router1");
//        Portal portal1 = new Portal("Portal1",router);
//        Portal portal2 = new Portal("Portal2",router);
//        MetaAgent user1 = new UserAgent("User1",portal1);
//        MetaAgent user2 = new UserAgent("User2",portal1);
//        MetaAgent user3 = new UserAgent("User3",portal2);
//        MetaAgent user4 = new UserAgent("User4",portal2);
//        
//        portal1.updateTable(user1.userName, user1);
//        router.updateTable(user1.userName, portal2);
//        portal1.updateTable(user2.userName, user2);
//        router.updateTable(user2.userName, portal2);
//        portal1.updateTable(user3.userName, user3);
//        portal1.updateTable(user4.userName, user4);
//        
//        
//        portal2.updateTable(user3.userName, user3);
//        router.updateTable(user3.userName, portal1);
//        portal2.updateTable(user4.userName, user4);
//        router.updateTable(user4.userName, portal1);
//        portal2.updateTable(user1.userName, user1);
//        portal2.updateTable(user2.userName, user2);
//        
//        
//        System.out.println(router.routing.containsKey(user1.userName));
//        System.out.println(portal1.routingTable.containsKey(user1.userName));
//        
//        System.out.println(router.routing.containsKey(user2.userName));
//        System.out.println(portal1.routingTable.containsKey(user2.userName));
//        
//        System.out.println(router.routing.containsKey(user3.userName));
//        System.out.println(portal2.routingTable.containsKey(user3.userName));
//        
//        System.out.println(router.routing.containsKey(user4.userName));
//        System.out.println(portal2.routingTable.containsKey(user4.userName));
//        
//        System.out.println(portal1.routingTable.containsKey("User2"));
//        System.out.println(portal2.routingTable.containsKey("User2"));
//        
//        
//        System.out.println("Portal1 HashMap: " + portal1.routingTable.toString());
//        System.out.println("Portal2 HashMap: " + portal2.routingTable.toString());
        
        
//        Message msg = new Message("User3", "appropriate message", "User1");
//        Message msg1 = new Message("User4", "appropriate message", "User1");
//        Message msg2 = new Message("User3", "appropriate message", "User2");
//        Message msg3 = new Message("User4", "appropriate message", "User2");
//        Message msg4 = new Message("User2", "appropriate message", "User3");
//        Message msg5 = new Message("User2", "appropriate message", "User4");
//        Message msg6 = new Message("User1", "appropriate message", "User3");
//        Message msg7 = new Message("User1", "appropriate message", "User4");
//        user1.messageHandler(msg);
//        user1.messageHandler(msg1);
//        user2.messageHandler(msg2);
//        user2.messageHandler(msg3);
//      user3.messageHandler(msg4);
//      user4.messageHandler(msg5);
//      user3.messageHandler(msg6);
         //user4.messageHandler(msg7);
        
        //System.out.println(router.routing.toString());
        //user1.
        
        //Sending a message ebtween two agents on the same Portal.
        Portal portal1 = new Portal("p1");
        UserAgent agent1 = new UserAgent("a1", portal1);
        portal1.addAgent(agent1);
        
        UserAgent agent2 = new UserAgent("a2", portal1);
        portal1.addAgent(agent2);
        
        agent1.SendMessage(new Message("a2", "Hi!", "agent1"));
        
        //------------------------------------------------------------
        //Sending a message between two agents on different portals.
        Portal portal2 = new Portal("p2", portal1);
        UserAgent agent3 = new UserAgent("a3", portal2);
        
        portal2.addAgent(agent3);
        
        portal1.setPortal(portal2);
        
        agent2.SendMessage(new Message("a3", "Hello agent3!", "a2"));
        
        /*for (int i = 0; i<10; i++)
        {
            agent2.SendMessage(new Message("a1", "Hi " + i + " times!", "gdgdgfdfg"));
            Thread.sleep(1000);
        }*/
    }
}