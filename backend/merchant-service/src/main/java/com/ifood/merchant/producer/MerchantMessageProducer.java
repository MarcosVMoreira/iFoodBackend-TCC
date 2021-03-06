package com.ifood.merchant.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifood.merchant.endpoint.model.entity.Merchant;
import com.ifood.merchant.endpoint.model.entity.MerchantAsyncPayload;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MerchantMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private static final String USER_EXCHANGE_NAME = "ifood-exchange";

    public void sendMerchantDataToRabbit (Merchant merchant) {
        try {
            MerchantAsyncPayload payload = MerchantAsyncPayload.builder()
                    .email(merchant.getEmail())
                    .id(merchant.getId())
                    .build();
            String json = new ObjectMapper().writeValueAsString(payload);
            rabbitTemplate.convertAndSend(USER_EXCHANGE_NAME, "", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
