package shop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.config.kafka.KafkaProcessor;
import shop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_DecreaseInventory(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener DecreaseInventory : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseInventory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancle'"
    )
    public void wheneverOrderCancle_IncreasedInventory(
        @Payload OrderCancle orderCancle
    ) {
        OrderCancle event = orderCancle;
        System.out.println(
            "\n\n##### listener IncreasedInventory : " + orderCancle + "\n\n"
        );

        // Sample Logic //
        Inventory.increasedInventory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
