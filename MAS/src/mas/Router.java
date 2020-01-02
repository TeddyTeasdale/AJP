/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author T7091808
 */
public class Router extends MetaAgent
{
    protected volatile TreeMap<String, MetaAgent> routing = new TreeMap();
    
    public Router(String userName)
    {
        super(userName, null);
    }
    
    public void connectRouter()
    {
        if(!portalList.isEmpty())
        {
            for(Portal pList : portalList)
            {
                pList.setRouter(this);
                
                for(Map.Entry<String, MetaAgent> mapRouting : pList.routingTable.entrySet())
                {
                    String name = mapRouting.getKey();
                    MetaAgent portalValue = mapRouting.getValue();
                    
                    if(!routing.containsKey(name))
                    {
                        if(portalValue.equals(pList.portal)) //update Router routing with username and portal reference
                            routing.put(name, pList.portal);
                        else
                            routing.put(name, portalValue.portal);
                    }
                    
                    //System.out.println(name + " " + portalValue.userName);
                    //System.out.println(portalValue.equals(pList.portal));
                    if(portalValue.equals(pList.portal))
                        pList.routingTable.replace(name, this);
                }
            }
        }
    }

    @Override
    public void messageHandler(Message message) 
    {
        if(routing.containsKey(message.getReceiver()))
        {
            try
            {
                System.out.println("Router " + this.userName + ": Passed though router");
                routing.get(message.getReceiver()).put(message);
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
        else
            System.out.println("Router " + this.userName + ": Message receiver doesn't exist!");
    }
}