package xyz.msprpayetonkawa.apicrm.client;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

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
    private String nom;
    private String prenom;
    private String email;
    private String company;

    private boolean prospects;
    // constructeurs, getters, setters (vous pouvez générer ces méthodes automatiquement)
}
