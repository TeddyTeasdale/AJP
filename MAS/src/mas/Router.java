/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;


/**
 *
 * @author T7091808
 */
public class Router extends MetaAgent
{
    HashMap<String, MetaAgent> routing = new HashMap();
    
    public Router(String userName)
    {
        
        super(userName);
        
    }
    
    public void updateTable(String userAgentName, MetaAgent portal)
    {
        routing.put(userAgentName, portal);
        synchroniseUpdate(userAgentName);
    }
    
    public void synchroniseUpdate(String userAgentName)
    {
        Iterator mapRouting = routing.entrySet().iterator();
        
        while(mapRouting.hasNext())
        {
           
            Map.Entry routingElement = (Map.Entry)mapRouting.next();
            Portal p = (Portal)routingElement.getValue();
            p.updateTable(userAgentName, this);
        }
    }

    @Override
    public void messageHandler(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
