
package xyz.msprpayetonkawa.apicrm.order;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import xyz.msprpayetonkawa.apicrm.client.Customer;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String uid;
    private Date dateCreated;
    private Customer customer;

}