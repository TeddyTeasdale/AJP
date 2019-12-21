/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    ArrayList<Portal> portalMap = new ArrayList<>();
    
    private Router portalRouter;
    
    //Single Portal communication
    public Portal(String userName)
    {
        super(userName, null);
        this.routingTable = new TreeMap<String, MetaAgent>();
        this.portalRouter = null;
    }
    
    //Portal to Portal communication.
    public Portal(String userName, Portal portal)
    {
        super(userName, portal);
        this.routingTable = new TreeMap<String, MetaAgent>();
        this.portalRouter = null;
        synchAgents();
    }
    
    //Portal to Router communication
    public Portal(String userName, Router router)
    {
        super(userName, null);
        this.routingTable = new TreeMap<String, MetaAgent>();
        this.portalRouter = router;
    }
    
    public void setPortal(Portal portal)
    {
        this.portal = portal;
    }
    
    public void addAgent(MetaAgent agent)
    {
        routingTable.put(agent.userName, agent);
        System.out.println("add");
        if(this.portal != null)
        {
            portal.routingTable.put(agent.userName, this);
            System.out.println("Adding agent");
        }
        // if this.portal != null notify that portal
    }
    
    private void synchAgents()
    {
        if(this.portal != null)
        {
            for(Map.Entry<String, MetaAgent> mapRouting : portal.routingTable.entrySet())
            {
                String name = mapRouting.getKey();
                
                if(!routingTable.containsKey(name))
                {
                    routingTable.put(name, this.portal);
                }
            }
        }
    }
    
    @Override
    public void messageHandler(Message message)
    {
        //System.out.println("Portal Contains Key: " + routingTable.containsKey(message.getReceiver()));
        System.out.println("Passed: " + this.userName);
        
        if(message.getReceiver().equals(this.userName))
        {
            System.out.println("Message direct to portal: " + message.toString());
        }
        else if(routingTable.containsKey(message.getReceiver()))
        {
            try
            {
                routingTable.get(message.getReceiver()).put(message);
            }catch (InterruptedException ex)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println("Portal: " + this.userName + " - No idea who this is for!");
        }
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