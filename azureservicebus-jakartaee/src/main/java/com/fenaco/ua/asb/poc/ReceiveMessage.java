package com.fenaco.ua.asb.poc;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import com.microsoft.azure.servicebus.IMessage;
import fish.payara.cloud.connectors.azuresb.api.AzureSBListener;
import fish.payara.cloud.connectors.azuresb.api.OnAzureSBMessage;


/*

 * Declares the class as a Message Driven Bean (MDB). This is an EJB annotation
 * which means that the class reacts to events from external sources (in this
 * case it's the Azure Service Bus). Properties of the bean are specified in
 * @ActivationConfigProperty annotations.
 */

@MessageDriven(activationConfig = {
    // The name of the service bus
    @ActivationConfigProperty(propertyName = "nameSpace", propertyValue = "eval-ua-fenaco"),
    // The name of the key being used.
    @ActivationConfigProperty(propertyName = "sasKeyName", propertyValue = "RootManageSharedAccessKey"),
    // The contents of the key being used.
    @ActivationConfigProperty(propertyName = "sasKey", propertyValue = "KvUOl6HHo8Tn7NSAmTcLUjX7zYE/ZCLzKyAtk6XJN7g="),

    // The name of the queue to listen on.
    @ActivationConfigProperty(propertyName = "queueName", propertyValue = "queue"),
 
    // The interval (in seconds) for polling the queue.
    @ActivationConfigProperty(propertyName = "pollInterval", propertyValue = "1"),
    
    @ActivationConfigProperty(propertyName = "connectionTimeout", propertyValue = "30"), 
    @ActivationConfigProperty(propertyName = "qos", propertyValue = "2")

})

// Implements the Listener interface defined in the Azure Cloud Connector API.

public class ReceiveMessage implements AzureSBListener {

    /*
     * Specifies that this method listens asynchronously for messages on the queue
     * defined for the class.
     */
    @OnAzureSBMessage
    public void receiveMessage(IMessage message) {
        // Print the message to the server log.
        System.out.println("Message received: \"" + new String(message.getBody()) + "\"");
    }
}