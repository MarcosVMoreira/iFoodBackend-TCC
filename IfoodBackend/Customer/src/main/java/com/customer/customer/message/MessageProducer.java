package com.customer.customer.message;


import com.customer.customer.endpoint.DTO.Customer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    public boolean sendMessageSaveCustomer (Customer payload, MessageSource restSource) {
        Message<Customer> message = MessageBuilder.withPayload(payload).build();
        return restSource.sendMessageToSaveCustomerChannel().send(message);
    }

    public boolean sendMessageUpdateCustomer (Customer payload, MessageSource restSource) {
        Message<Customer> message = MessageBuilder.withPayload(payload).build();
        return restSource.sendMessageToUpdateCustomerChannel().send(message);
    }

    public boolean sendMessageDeleteCustomer (Long id, MessageSource restSource) {
        Message<Long> message = MessageBuilder.withPayload(id).build();
        return restSource.sendMessageToDeleteCustomerChannel().send(message);
    }



//    public boolean sendMessageCustomer (Address payload, MessageSource restSource) {
//        Message<Address> message = MessageBuilder.withPayload(payload).build();
//        return restSource.sendMessageToCustomerChannel().send(message);
//    }


}