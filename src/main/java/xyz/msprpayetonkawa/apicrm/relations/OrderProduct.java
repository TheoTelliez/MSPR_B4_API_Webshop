package xyz.msprpayetonkawa.apicrm.relations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import xyz.msprpayetonkawa.apicrm.order.Order;
import xyz.msprpayetonkawa.apicrm.product.Product;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderProduct {
    @EmbeddedId
    private OrderProductKey id = new OrderProductKey();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("productList")
    Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    int quantityOrdered;

    public OrderProduct(Order order, Product product, int quantityOrdered) {
        this.order = order;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
    }
}
