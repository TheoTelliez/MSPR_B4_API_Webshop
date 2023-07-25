package xyz.msprpayetonkawa.apicrm.client;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import xyz.msprpayetonkawa.apicrm.Order.Order;

import java.util.List;


@Node("Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Customer {
    @Id @GeneratedValue
    private Long id;
    private String uid;
    private String name;
    private List<Order> listOrder;

    // constructeurs, getters, setters (vous pouvez générer ces méthodes automatiquement)
}
