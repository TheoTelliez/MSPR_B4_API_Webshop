package xyz.msprpayetonkawa.apiwebshop.product;

import jakarta.persistence.*;
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

