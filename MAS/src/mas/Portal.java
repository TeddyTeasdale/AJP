/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t7091808
 */
public class Portal extends MetaAgent
{
    public volatile TreeMap<String, MetaAgent> routingTable; 
    //private Router userRouter;
    
    public Portal(String userName)
    {
        super(userName, null);
        this.routingTable = new TreeMap<>();
        //this.userRouter = router;
    }
    
    public Portal( String userName, Router router)
    {
        super(userName, null);
        this.routingTable = new TreeMap<>();
        //this.userRouter = router;
    }
    
    public void setPortal(Portal portal)
    {
        this.portal = portal;
    }
    
    @Override
    public void messageHandler(Message message)
    {
        System.out.println("Portal Contains Key: " + routingTable.containsKey(message.getReceiver()));
        
        if(message.getReceiver().equals(this.userName))
        {
            System.out.println("Message direct to portal: " + message.toString());
        }
        else if(routingTable.containsKey(message.getReceiver()))
        {
            try {
                routingTable.get(message.getReceiver()).put(message);
            } catch (InterruptedException ex) {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println("Portal: No idea who this is for!");
        }
    }
    
    public void addAgent(MetaAgent agent)
    {
        routingTable.put(agent.userName, agent);
        
        // if this.portal != null notify that portal
    }
    
    public void updateTable(String name ,MetaAgent p)
    {
        if(!this.routingTable.containsKey(name))
        {
            System.out.println("Entered Portal UpdateTable");
            routingTable.put(name, p);
        }
    }
}