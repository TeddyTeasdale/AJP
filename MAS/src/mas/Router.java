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
 * @author T7091808
 */
public class Router extends MetaAgent
{
    
    
    public Router(String userName, ArrayBlockingQueue queue)
    {
        super(userName,queue);
        
    }
    
    public void updateTable(String n, MetaAgent g)
    {
        
    }

    @Override
    public void messageHandler(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
