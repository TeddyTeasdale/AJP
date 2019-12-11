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
    
    private HashMap<String, MetaAgent> routingTable; 
    private Router userRouter;
    
    public Portal( String userName, Portal userPortal, ArrayBlockingQueue queue, Router router)
    {
        super(userName, userPortal, queue);
        this.routingTable = new HashMap();
        this.userRouter = router;
    }
    
    @Override
    public void messageHandler(Message message)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void updateTable(MetaAgent p)
    {
        
        routingTable.put(p.userName, p);
        this.userRouter.updateTable(userName, this);
        
    }
}
