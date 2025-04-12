package shop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeleveryCancle extends AbstractEvent {

    private Long id;

    public DeleveryCancle(Delivery aggregate) {
        super(aggregate);
    }

    public DeleveryCancle() {
        super();
    }
}
//>>> DDD / Domain Event
