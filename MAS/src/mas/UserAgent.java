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
public class UserAgent extends MetaAgent
{
    protected static Portal userPortal;

    public UserAgent(String userName, Portal userPortal) 
    {
        super(userName);
        this.userPortal = userPortal;
    }

    public Portal getUserPortal() {
        return userPortal;
    }

    
    @Override
    public void messageHandler(Message message)
    {
        if(message.getReceiver().equals(this.userName))
        {
            System.out.println(message.toString());
        }
        else
        {
            try
            {
                this.userPortal.queue.put(message);
            }catch(InterruptedException ie)
            {
                System.out.println("Error!");
            }
        }
    }
}
