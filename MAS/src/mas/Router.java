/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author T7091808
 */
public class Router extends MetaAgent
{
    public volatile HashMap<String, MetaAgent> routing = new HashMap();
    
    public Router(String userName)
    {
        
        super(userName);
        
    }
    
    public synchronized void updateTable(String userAgentName, MetaAgent portal)
    {
        routing.put(userAgentName, portal);
        synchroniseUpdate(userAgentName);
    }
    
    public synchronized void synchroniseUpdate(String userAgentName)
    {
        Iterator mapRouting = routing.entrySet().iterator();
        
        while(mapRouting.hasNext())
        {
            System.out.println("Entered Routing While");
            Map.Entry routingElement = (Map.Entry)mapRouting.next();
            Portal p = (Portal)routingElement.getValue();
            System.out.println(p.userName);
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
                routing.get(message.getReceiver()).queue.put(message);
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
