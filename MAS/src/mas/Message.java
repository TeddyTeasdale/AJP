/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas;

/**
 *
 * @author t7091808
 */
public class Message 
{
    private final String receiver; //Will be UserAgent with GUI
    private final String messageBody;
    private final String sender;
    
    Message(String receiver, String messageBody, String sender)
    {
        this.receiver = receiver;
        this.messageBody = messageBody;
        this.sender = sender;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public String getSender()
    {
        return sender;
    }
    
    @Override
    public String toString()
    {
        return "Message from: " + sender + "\nMessage: " + messageBody + "\nTo: " + receiver;
    }
    
}
