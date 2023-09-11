package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String Street;

    @Getter
    @Setter
    private Integer Number;

    @Getter
    @Setter
    @ManyToMany
    private Set<Customer> Owners;
}
