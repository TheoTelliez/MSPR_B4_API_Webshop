package xyz.msprpayetonkawa.apiwebshop.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import xyz.msprpayetonkawa.apiwebshop.client.Customer;
import jakarta.persistence.*;
import xyz.msprpayetonkawa.apiwebshop.relations.OrderProduct;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="orders")

public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String uid;
    private Date dateCreated;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("order")
    private List<OrderProduct> productList;
    @ManyToOne()
    private Customer customer;

}