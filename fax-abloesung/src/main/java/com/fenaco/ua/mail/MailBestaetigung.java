package com.fenaco.ua.mail;

import java.net.URI;
import java.util.Collection;
import java.util.Iterator;

import com.microsoft.azure.servicebus.ClientFactory;
import com.microsoft.azure.servicebus.ClientSettings;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.IMessageBrowser;
import com.microsoft.azure.servicebus.IMessageReceiver;
import com.microsoft.azure.servicebus.IMessageSender;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.management.ManagementException;
import com.microsoft.azure.servicebus.management.QueueDescription;
import com.microsoft.azure.servicebus.primitives.MessagingFactory;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

public class MailBestaetigung {

	private static String entityNameCreatedForAllTests = null;
	private static String receiveEntityPathForAllTest = null;

	private MessagingFactory factory;
	private IMessageSender sender;
	private IMessageReceiver receiver;
	private String entityName;
	private final String sessionId = null;
	private String receiveEntityPath;

	public static void main(String[] args) throws ManagementException, InterruptedException, ServiceBusException {

		MailBestaetigung mailBestaetigung = new MailBestaetigung();
		mailBestaetigung.init();
		mailBestaetigung.messageSenden();
		mailBestaetigung.messageLesen();

	}

	private void messageLesen() throws InterruptedException, ServiceBusException {
			this.receiver = ClientFactory.createMessageReceiverFromEntityPath(factory, this.receiveEntityPath,
					ReceiveMode.PEEKLOCK);
		IMessageBrowser browser = this.receiver;
		Collection<IMessage> listOfMessages  = browser.peekBatch(100);
		Iterator<IMessage> iter = listOfMessages.iterator();
		while(iter.hasNext()) {
			IMessage message = iter.next();
			System.out.println("Nachricht gelesen: " + message.getMessageId() + ", " + new String(message.getBody()));
		}		
	}

	private void messageSenden() throws InterruptedException, ServiceBusException {
		this.receiver = ClientFactory.createMessageReceiverFromEntityPath(factory, this.receiveEntityPath,
				ReceiveMode.PEEKLOCK);

		IMessageSender sender = this.sender;
		String sessionId = this.sessionId;
		Message message = new Message("Meine Fax Nachricht");
		if (sessionId != null) {
			message.setSessionId(sessionId);
		}
		sender.send(message);
		System.out.println("Nachricht verschickt: " + message.getMessageId());
	}

	private void init() throws ManagementException, InterruptedException, ServiceBusException {

		URI namespaceEndpointURI = MessageUtils.getNamespaceEndpointURI();
		// ClientSettings managementClientSettings = MessageUtils.getManagementClientSettings();
		if (this.shouldCreateEntityForEveryTest() || MailBestaetigung.entityNameCreatedForAllTests == null) {
			this.entityName = "mailBestaetigung";			
			this.receiveEntityPath = this.entityName;
			QueueDescription queueDescription = new QueueDescription(this.entityName);
			queueDescription.setEnablePartitioning(this.isEntityPartitioned());
			// EntityManager.createEntity(namespaceEndpointURI, managementClientSettings, queueDescription);
			if (!this.shouldCreateEntityForEveryTest()) {
				MailBestaetigung.entityNameCreatedForAllTests = entityName;
				MailBestaetigung.receiveEntityPathForAllTest = entityName;
			}
		} else {
			this.entityName = MailBestaetigung.entityNameCreatedForAllTests;
			this.receiveEntityPath = MailBestaetigung.receiveEntityPathForAllTest;
		}

		this.factory = MessagingFactory.createFromNamespaceEndpointURI(namespaceEndpointURI,
				MessageUtils.getClientSettings());
		this.sender = ClientFactory.createMessageSenderFromEntityPath(namespaceEndpointURI, this.entityName,
				MessageUtils.getClientSettings());

	}

	public String getEntityNamePrefix() {
		return "QueueSendReceiveTests";
	}

	public boolean shouldCreateEntityForEveryTest() {
		return MessageUtils.shouldCreateEntityForEveryTest();
	}

	public boolean isEntityPartitioned() {
		return false;
	}

}
