/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t7091808
 */
public abstract class MetaAgent extends ArrayBlockingQueue<Message> implements Runnable
{
    protected String userName;
    protected Portal portal;
    
    private Thread t;
    private boolean exit;

    public MetaAgent(String userName, Portal portal) 
    {
        super(100);
        
        this.userName = userName;
        this.portal = portal;
        
        this.exit = false;
        startThread();
    }

    private void startThread() 
    {
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run()
    {
        while(!exit)
        {
            try {
                messageHandler(this.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stop()
    {
        exit = true;
    }
    
    public void messageHandler(Message message)
    {
        System.out.println(message.getMessageBody());
    }
    
}
