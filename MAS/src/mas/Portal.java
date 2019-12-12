/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author t7091808
 */
public class Portal extends MetaAgent
{
    
    public HashMap<String, MetaAgent> routingTable; 
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
        if(routingTable.containsKey(message.getReceiver()))
        {
            try
            {
                routingTable.get(message.getReceiver()).queue.put(message);
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
        else
        {
            System.out.println("Message receiver doesn't exist!");
        }
    }
    
    public void updateTable(String name ,MetaAgent p)
    {
        
        if(!(this.routingTable.containsKey(name)))
        {
            routingTable.put(p.userName, p);
            
        }
    }
}
