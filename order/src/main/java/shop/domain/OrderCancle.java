package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancle extends AbstractEvent {

    private Long id;

    public OrderCancle(Order aggregate) {
        super(aggregate);
    }

    public OrderCancle() {
        super();
    }
}
//>>> DDD / Domain Event
