package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String Name;

    @Getter
    @Setter
    @ManyToMany
    private Set<Address> Addresses;

    @Getter
    @Setter
    @ManyToMany
    private Set<CreditCard> CreditCards;
}
