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
 * @author t7091808
 */
public class Portal extends MetaAgent
{
    
    public volatile HashMap<String, MetaAgent> routingTable; 
    private Router userRouter;
    
    public Portal( String userName, Router router)
    {
        super(userName);
        this.routingTable = new HashMap();
        this.userRouter = router;
    }
    
    @Override
    public void messageHandler(Message message)
    {
        System.out.println("Portal Contains Key: " + routingTable.containsKey(message.getReceiver()));
        
        if(routingTable.containsKey(message.getReceiver()))
        {
            try
            {
                /*Map.Entry routingElement;
                Iterator mapRouting = routingTable.entrySet().iterator();
        
                while(mapRouting.hasNext())
                {
                    routingElement = (Map.Entry)mapRouting.next();
                    MetaAgent meta = (MetaAgent)routingElement.getValue();
                    if(meta.userName.equals(message.getReceiver()))
                    {
                        break;
                    }
                    
                }*/
                
                routingTable.get(message.getReceiver()).queue.put(message);
                
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
        else
        {
            try
            {
                userRouter.queue.put(message);
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
    }
    
        public synchronized void updateTable(String name ,MetaAgent p)
        {
            if(!this.routingTable.containsKey(name))
            {
                System.out.println("Entered Portal UpdateTable");
                routingTable.put(name, p);
            }
        }
}
