package xyz.msprpayetonkawa.apiwebshop.client;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="customer")

public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String uid;
    private String nom;
    private String prenom;
    private String email;
    private String company;
    private boolean prospect;

}
