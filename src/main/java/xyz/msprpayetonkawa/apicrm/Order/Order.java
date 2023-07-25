
package xyz.msprpayetonkawa.apicrm.Order;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import xyz.msprpayetonkawa.apicrm.client.Customer;
import xyz.msprpayetonkawa.apicrm.product.Product;

import java.util.Date;
import java.util.List;

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
    //private List<Product> productList;
    private Customer customer;

}