/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author T7091808
 */
public class Router extends MetaAgent
{
    public volatile TreeMap<String, MetaAgent> routing = new TreeMap();
    
    public Router(String userName)
    {
        super(userName, null);
        
    }
    
    public synchronized void updateTable(String userAgentName, MetaAgent portal)
    {
        routing.put(userAgentName, portal);
        synchroniseUpdate(userAgentName);
    }
    
    public synchronized void synchroniseUpdate(String userAgentName)
    {
        for(Map.Entry<String, MetaAgent> mapRouting : routing.entrySet())
        {
            //mapRouting.getValue().portal.updateTable(userName, this);
            Portal p = (Portal)routing.get(userAgentName);
            p.updateTable(userAgentName, this);
        }
    }

    @Override
    public void messageHandler(Message message) 
    {
        if(routing.containsKey(message.getReceiver()))
        {
            try
            {
                System.out.println("Passed though router");
                routing.get(message.getReceiver()).put(message);
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
        else
        {
            System.out.println("Router: Message receiver doesn't exist!");
        }
    }
}