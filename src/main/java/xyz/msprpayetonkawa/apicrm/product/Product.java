package xyz.msprpayetonkawa.apicrm.product;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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

