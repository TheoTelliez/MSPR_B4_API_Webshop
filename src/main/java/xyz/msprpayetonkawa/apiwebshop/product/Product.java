package xyz.msprpayetonkawa.apiwebshop.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="product")

public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String uid;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
}

