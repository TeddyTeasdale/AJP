/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author t7091808
 */
public abstract class MetaAgent
{
    protected String userName;
    
    protected ArrayBlockingQueue queue;
    private Thread t;
    private boolean exit;

    public MetaAgent(String userName) 
    {
        this.userName = userName;
        this.queue = new ArrayBlockingQueue(10);
        this.exit = false;
        startThread();
        
    }

    
    

    public void startThread() 
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(!exit)
                {
                    try
                    {
                        messageHandler((Message)queue.take());
                    }catch(InterruptedException ie)
                    {
                        System.out.println("Error! ");
                    }
                   
                }
            }  
        });
        t.start();
    }
    
    public void stop()
    {
        exit = true;
    }
    
    public abstract void messageHandler(Message message);
    
    
}
