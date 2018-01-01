package com.myapps.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageResult;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        QueueClient client = new QueueClient(sqs, "testq");
        SendMessageResult result = client.sendMessage("howdy?");

        System.out.println("Message id: "+result.getMessageId());
    }
}
