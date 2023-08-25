package xyz.msprpayetonkawa.apiwebshop.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String role;

    public Customer(Long id, String uid, String nom, String prenom, String email, String company, boolean prospect) {
        this.id = id;
        this.uid = uid;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.company = company;
        this.prospect = prospect;
    }
}
