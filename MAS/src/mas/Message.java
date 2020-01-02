/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

import java.io.Serializable;

/**
 *
 * @author t7091808
 */
public class Message
{
    private final static long serialVersionUID = 1L;
    private final String RECEIVER; //Will be UserAgent with GUI
    private final String MESSAGEBODY;
    private final String SENDER;
    
    Message(String receiver, String messageBody, String sender)
    {
        this.RECEIVER = receiver;
        this.MESSAGEBODY = messageBody;
        this.SENDER = sender;
    }

    public String getReceiver()
    {
        return RECEIVER;
    }

    public String getMessageBody()
    {
        return MESSAGEBODY;
    }

    public String getSender()
    {
        return SENDER;
    }
    
    public long getSerialVersionUID()
    {
        return this.serialVersionUID;
    }
    
    @Override
    public String toString()
    {
        return "Message from: " + SENDER + "\nMessage: " + MESSAGEBODY + "\nTo: " + RECEIVER;
    }
    
}