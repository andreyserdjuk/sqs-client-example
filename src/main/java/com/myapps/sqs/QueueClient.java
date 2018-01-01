package com.myapps.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class QueueClient {
    private final AmazonSQS sqs;
    private final String qName;

    QueueClient(AmazonSQS sqs, String qName) {
        this.sqs = sqs;
        this.qName = qName;
    }

    public SendMessageResult sendMessage(String message) {
        CreateQueueResult create_result = sqs.createQueue(qName);

        create_result.getQueueUrl();

        String queueUrl = sqs.getQueueUrl(qName).getQueueUrl();

        SendMessageRequest messageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(5);

        return sqs.sendMessage(messageRequest);
    }
}
