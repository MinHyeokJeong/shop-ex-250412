package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class OrderCancle extends AbstractEvent {

    private Long id;
}
