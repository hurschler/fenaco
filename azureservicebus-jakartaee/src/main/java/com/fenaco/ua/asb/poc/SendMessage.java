package com.fenaco.ua.asb.poc;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.resource.ConnectionFactoryDefinition;
import javax.resource.ResourceException;
import javax.resource.spi.TransactionSupport.TransactionSupportLevel;
import javax.transaction.Transactional;

import com.microsoft.azure.servicebus.Message;

import fish.payara.cloud.connectors.azuresb.api.AzureSBConnection;
import fish.payara.cloud.connectors.azuresb.api.AzureSBConnectionFactory;

/*
 * Defines an application-wide Connection Factory. This can be put in any class,
 * and is an alternative to creating the Connection Factory in the server.
 */
@ConnectionFactoryDefinition(
        // Defines the JNDI name of the Connection Factory.
        name = "java:app/env/AzureSBConnectionFactory",
 
        // The description of the Connection Factory
        description = "Azure SB Conn Factory",
 
        /*
         * The interface which the Connection Factory implements. In this case it's an
         * interface defined in the Resource Adapter.
         */
        interfaceName = "fish.payara.cloud.connectors.azuresb.api.AzureSBConnectionFactory",
 
        // The name of the Resource Adapter being used.
        resourceAdapter = "azure-sb-rar-0.6.0-SNAPSHOT",
 
        // The minimum and maximum number of connections in the Connection Pool.
        minPoolSize = 15, maxPoolSize = 30,
 
        // The level of transactionality of the connections.
        transactionSupport = TransactionSupportLevel.NoTransaction,
 
        // Any extra properties necessary for the interface being extended.
        properties = {
                // The name of the queue to send messages to
                "queueName=queue",
 
                // The name of the service bus.
                "nameSpace=eval-ua-fenaco",
 
                // The name of the key being used.
                "sasKeyName=RootManageSharedAccessKey",
 
                // The contents of the key being used.
                "sasKey=KvUOl6HHo8Tn7NSAmTcLUjX7zYE/ZCLzKyAtk6XJN7g=" })
 
/*
 * The message is being sent on an EJB timer, so the class is declared as a
 * stateless EJB.
 */
@Stateless
public class SendMessage {
 
    // The Connection Factory is injected with the name specified above.
    @Resource(lookup = "java:app/env/AzureSBConnectionFactory")
    private AzureSBConnectionFactory factory;
 
    /*
     * This method is called every 3 seconds, and this 3 second interval will be
     * reset if the server restarts (non-persistent).
     */
    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void pingMessage() {
        // Creates a connection
        try (AzureSBConnection conn = factory.getConnection()) {
            // Sends the message to the specified queue.
        	for (int i = 0; i < 10; i++) {
        		conn.sendMessage(new Message("Hello World mit Transaction commit! " + i));		
        		System.out.println("Send Message" + i);
			}
        } catch (ResourceException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, "Connection failed.", ex);
        } catch (Exception ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, "Connection failed to close.", ex);
        }
    }
 
}